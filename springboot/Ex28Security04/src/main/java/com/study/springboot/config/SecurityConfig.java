package com.study.springboot.config;

import com.study.springboot.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
@EnableWebSecurity // 웹 보안 활성화를 위한 어노테이션
@RequiredArgsConstructor
public class SecurityConfig {
    final private CustomOAuth2UserService customOAuth2UserService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf( (csrf) -> csrf.disable() )
//            .csrf((csrf)->csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))

            // CORS 모두 허용 (개발용)
//            .cors(cors -> cors.configurationSource(request -> {
//                CorsConfiguration config = new CorsConfiguration();
//                config.setAllowedOrigins(Arrays.asList("*"));
//                config.setAllowedMethods(Arrays.asList("*"));
//                config.setAllowedHeaders(Arrays.asList("*"));
//                return config;
//            }))

                // CORS 설정 (특정 도메인만 허용)
//                .cors(cors -> cors
//                        .configurationSource(request -> {
//                            CorsConfiguration config = new CorsConfiguration();
//                            config.setAllowedOrigins(Arrays.asList(
//                                    "https://localhost:3000",
//                                    "https://api.myapp.com"
//                        ));
//                        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//                        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//                        config.setAllowCredentials(true);
//                        return config;
//                    })
//            )

            .authorizeHttpRequests( (auth) -> auth
                //루트 밑의 모든 경로에 대한 요청을 허가한다.
                .requestMatchers( new AntPathRequestMatcher("/**") ).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/loginForm") ).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/joinForm") ).permitAll()
                .requestMatchers( "/admin" ).hasRole("ADMIN")
                .requestMatchers( "/my/**" ).hasAnyRole("ADMIN", "USER")
                //그외의 모든 요청에 대해서는 인증을 한다.
                .anyRequest().authenticated() )
            //로그인 인증에 대한 설정을 시작
            .formLogin( (formLogin) -> formLogin
                    //로그인 페이지를 /loginForm URI로 하겠다.
                    .loginPage("/loginForm")
                    //로그인 액션 URI
                    .loginProcessingUrl("/loginAction")
                    //로그인 성공시 호출되는 URI를 지정
                    .defaultSuccessUrl("/")
                    //인증성공 후 별도의 처리가 필요한 경우 커스텀 핸들러를 생성/등록한다.
                    .successHandler(((request, response,
                                      authentication) -> {
                        System.out.println("로그인 성공했습니다.");
                        response.sendRedirect("/");
                    } ))
                    //인증실패 시 에러페이지 등록
                    .failureUrl("/loginForm?error")
                    //로그인 페이지를 모든 사용자에게 허용한다.
                    .permitAll())
                //로그아웃 처리
                .logout((auth) -> auth
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logoutAction"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true) //세션 객체을 해제(내부 저장 데이터도 소멸)
                        .deleteCookies("JSESSIONID") //reponse 헤더에 Set Cookie에 ""을 넣어준다.
                )
                //SNS 로그인
                .oauth2Login( oauth2 -> oauth2
                    .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
                    .userService(customOAuth2UserService))
                    .successHandler(successHandler())
                    .failureHandler(failureHandler())
        );
        return http.build();
    }

    //REST API용 설정 (일반적인 운영용)
    @Bean
    SimpleUrlAuthenticationSuccessHandler successHandler(){
        return new SimpleUrlAuthenticationSuccessHandler("/snsLoginSuccess");
    }
    @Bean
    SimpleUrlAuthenticationFailureHandler failureHandler(){
        return new SimpleUrlAuthenticationFailureHandler("/snsLoginFailuer");
    }
    //BCrypt 암호화 엔코더 빈 생성
    @Bean
    public PasswordEncoder passwordEncoder() {
        //스프링 시큐리티 6.4.x버전 공식 지원하는 PasswordEncoder 구현 클래스들은 아래와 같습니다.
        //BcryptPasswordEncoder : BCrypt 해시 함수를 사용해 비밀번호를 암호화
        //Argon2PasswordEncoder : Argon2 해시 함수를 사용해 비밀번호를 암호화
        //Pbkdf2PasswordEncoder : PBKDF2 해시 함수를 사용해 비밀번호를 암호화
        //SCryptPasswordEncoder : SCrypt 해시 함수를 사용해 비밀번호를 암호화

        //암호화 강도는 4 ~ 31까지 설정할 수 있으며, 기본강도는 10이다.
        return new BCryptPasswordEncoder( 12 );
        //return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        //return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        //return SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
