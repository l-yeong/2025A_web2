package web2.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import web2.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import web2.service.JwtService;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor


public class JwtAuthFilter extends OncePerRequestFilter {
    // 내가 만든 토큰 인증(jwtService) 방법을 (시큐리티방식)UsernamePasswordAuthenticationToken 통합

    //[1] 내가 만든 토큰 방식
    private final JwtService jwtService;

    //[2] 기존 시큐리티 방식의 필터 커스텀, 상속받기( OncePerRequestFilter), doFilterInternal 재정의
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. 세션이 아닌 쿠기방식이라서 먼저 쿠키에서 토큰추출
        String token = null;
        if(request.getCookies()!=null){ //쿠키가 존재하면
            for(Cookie cookie : request.getCookies()){ //모든 쿠기들을 반복문 돌려서
                if(cookie.getName().equals("loginUser")){//로그인제 쿠키가 존재하면
                    token =cookie.getValue(); // 쿠기 값(토큰) 꺼내기
                }
            }
        }
        // 2.UserNamePasswordAuthenticationToken 을 내 재 정의하기
        if(token != null && jwtService.checkToken(token)){ // 토큰이 유효하면
            String uid = jwtService.getUid(token); // 아이디 꺼내기
            String urole = jwtService.getUrole(token); // **권한꺼내기**
            // ********* 시큐리티 원하는 서명(UserNamePasswordAuthenticationToken) 만들어주기 *********
            //UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken("id","password","role");
            //UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(uid,null, List.of(new SimpleGrantedAuthority("ROLE_XXX"), new SimpleGrantedAuthority("ROLE_XXX")));
            // 2-2 : 시큐리티 토큰 생성
            UsernamePasswordAuthenticationToken t = new UsernamePasswordAuthenticationToken(uid,null,List.of(new SimpleGrantedAuthority("ROLE_"+urole)));
            // 2-3 : 시큐리티 사용할수 있게 토큰 저장, SecurityContext(시큐리티메모리)
            SecurityContextHolder.getContext().setAuthentication(t);
        }//if end
        // 3 : 다른 필터에서 해당하는 토큰필터를 호출 할수 있도록
        filterChain.doFilter(request,response);
    }//func end


}//class end
