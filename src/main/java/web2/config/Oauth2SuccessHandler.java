package web2.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web2.service.JwtService;
import web2.service.UserService;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Oauth2SuccessHandler implements AuthenticationSuccessHandler {



    // [1] AuthenticationSuccessHandler 구현체를 만든다
    // [2] onAuthenticationSuccess 메소드 구현한다.

private final JwtService jwtService;
private final UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 타사 *로그인 성공 이후* 로직 커스텀( 실패 커스텀 없다 )
        // [3] 로그인 성공한 회원의 타사 발급한 토큰 확인
        System.out.println(authentication); // authentication 인증(토큰,개인정보 등)

        // 3-1 : oauth2 관련 라이브러리 설치 : implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'

        // 3-2 : 로그인 성공한 토큰 확인, OAuth2AuthenticationToken, 타사의 회사명 
        OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;

        // 3-3 : 로그인 성공한 회원의 동의항목(정보), Oath2User 
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal(); // Principal() 주제(로그인성공한정보)
        System.out.println("oauth2User = " + oauth2User);

        // [4] google / kakao 인지 식별, 서로 다른 회사별 동의항목(다르다)
        String provider = authToken.getAuthorizedClientRegistrationId(); // 등록된 공급자 ID: google, kakao 등등
        System.out.println("provider = " + provider);

        String uid=null; String name=null; //동의 항목 정보
        if(provider.equals("google")){
            uid = oauth2User.getAttribute("email"); // oauth2User.getAttribute("동의항목명")
            name = oauth2User.getAttribute("name");
        }else if(provider.equals("kakao")){
            // 카카오의 동의항목(정보) profile_nickname,"kakao_account"
            Map<String,Object> kakaoAccount = oauth2User.getAttribute("kakao_account");
            Map<String,Object> profile =  (Map<String,Object>)kakaoAccount.get("profile"); //테스트 단계에서는 profile만
            uid = (String)profile.get("nickname"); // 테스트 단계에서 임의
            name = (String)profile.get("nickname");
        }

        // [7] oauth 정보를 데이터베이스 저장
        userService.oauth2UserSignUp(uid,name);

        // [5] 자사(우리)의 로그인 방식 통합
        Cookie cookie = new Cookie("loginUser",jwtService.createToken(uid,"USER"));
        cookie.setHttpOnly(true); cookie.setSecure(false);
        cookie.setPath("/"); cookie.setMaxAge(60*60);
        response.addCookie(cookie);

        // [6] 로그인 성공시 어디로 이동할지(프론트엔드 루트)
        response.sendRedirect("http://localhost:5173/"); //리액트 서버
        //response.sendRedirect("/"); //자바서버 메인경로 localhost:8080
        
        // 1. 어느 타사의 로그인 성공 인지 확인
        // 2. 로그인 성공한 동의항목(보기) 가져오기, 개인정보(아이디,회원명,주소,전화번호)
        // 3. 자사(우리)서버와 타사서버 통합 로그인
        // 4. 자사(우리)서버와 타사서버 통합 DB(최초 로그인이면 DB 저장, 아니면 DB 처리 없음)

    }//func end

}//class end
