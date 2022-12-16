package com.app.springsecurity.config;

import com.app.springsecurity.security.Custom403Handler;
import com.app.springsecurity.security.CustomLoginSuccessHandler;
import com.app.springsecurity.security.CustomUserDetailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Security의 설정
        // 1. 요청(URL)에 대한 인증과 허가에 대한 설정
        http.authorizeHttpRequests()
                        .antMatchers("/sample/sample").authenticated() // 해당 경로 요청 시 인증을 요구한다.
                        .antMatchers("/sample/all").permitAll()
                        .antMatchers("/sample/member").hasRole("USER")
                        .antMatchers("/sample/admin").hasRole("ADMIN");

        // 2. form 기반 인증처리 : 커스텀 로그인 페이지 설정 -> 성공 시 처리하는 핸들러 객체 등록
        http.formLogin().successHandler(successHandler());

        // 3. 허가 실패 403 : 권한 부족의 처리 핸들러
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());

        // 4. 로그아웃
        http.logout();

        // 5. 자동 로그인
        http.rememberMe().key("1234567").rememberMeParameter("remember-me").tokenValiditySeconds(60*60*24);
        return http.build();
    }

    public AccessDeniedHandler accessDeniedHandler(){
        return new Custom403Handler();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 테스트 환경
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails userDetails = User.builder()
//                .username("user1")
//                .password(passwordEncoder().encode("1111"))
//                .roles("USER")
//                .build();
//
//        log.info(">>>>>>>>>> userDetailService : " + passwordEncoder().encode("1111"));
//        log.info(">>>>>>>>>> " + userDetails);
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

}
