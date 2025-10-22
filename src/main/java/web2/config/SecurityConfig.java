package web2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// ============== 스프링 시큐리티 라이브러리 커스텀 ==============
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    // 시큐리티(보안)필터(검증/확인) 체인(연결고리)
    // 미리 만들어진 필터들이 다수 ...... 그런 필터들을 커스텀(수정)/제외/끄기
    private final JwtAuthFilter jwtAuthFilter;
    // !! : HTTP 관련 필터들을 커스텀, HTTP는 요청과 응답처리하는 웹 아키텍처
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        // [1] HTTP 요청에 따른 권한 커스텀
        //.authorizeHttpRequests(auth->auth.requestMatchers("경로"),권한)
        //.permitAll() : 모든 권한 (공개용)
        //.hasRole("권한명"), .hasAnyRole("권한명","권한명")
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/user/info").hasAnyRole("USER","ADMIN") // 2개 이상 기능, 권한명은 대문자
                .requestMatchers("/api/admin/**").hasRole("ADMIN") //ADMIN 관련 CONTROLLER는 "ADMIN"관련일때
                .requestMatchers("/**").permitAll());
        // [2] HTTP 요청에 csrf( 요청간의 해킹 공격 ) POST,PUT 자동 차단
        //http.csrf(csrf -> csrf.ignoringRequestMatchers("csrf 제외할경로"))
        http.csrf(csrf -> csrf.disable()); //개발단계 권장, csrf 사용안함

        // [3] 시큐리티내부에서 사용되는 (세션)토큰, UsernamePasswordAuthenticationToken
        // web2 실습에서는 쿠키 기반의 토근 구현중 = 시큐리티가 제공하는 세션 사용 안함
        // [3-1] 시큐리티 세션 끄기
        http.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // [3-2] UsernamePasswordAuthenticationFilter 을 개발자가 만든 토큰 대체
        //http.addFilterBefore(내가만든토큰객체필터, UsernamePasswordAuthenticationFilter.class)
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build(); // 커스텀 완료된 객체 반환

    }//func end

}//class end
