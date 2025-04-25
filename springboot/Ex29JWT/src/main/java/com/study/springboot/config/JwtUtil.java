package com.study.springboot.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    //annotation.Value : properties 또는 yml의 설정정보를 변수에 설정한다.
    @Value("${jwt.secretKey}") //토큰 시크릿키(암호화할때 사용하는 비공개키)
    private String secretKey;
    @Value("${jwt.expiration_time}") //토큰 유효 기간 ms단위
    private long expireTime;

    private final UserDetailsService userDetailsService;

    //@PostConstruct : 스프링 빈의 생명주기(생성,소멸,활성화)\
    // : 의존주입이 이루어진 후에 초기화를 스프링프레임워크가 수행해 주는 메소드에 붙임.
    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String userEmail, List<String> roleList){
        Claims claims = Jwts.claims().setSubject(userEmail);
        claims.put("roles", roleList);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) //정보 저장
                .setIssuedAt(now) //토큰 발행 시간 저장
                .setExpiration(new Date(now.getTime() + expireTime))//토큰 유효기간 설정
                //암호화 알고리즘과 signature에 들어가 secret값 설정
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    //JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token){
        String email = Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return new UsernamePasswordAuthenticationToken(
                userDetails, "", userDetails.getAuthorities());
    }
    //Request의 Header에서 token값을 가져옵니다. "X-AUTH-TOKEN" : "TOKEN값"
    public String resolveToken(HttpServletRequest request){
        return request.getHeader("X-AUTH-TOKEN");
    }
    //토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String token){
        try{
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return claims.getBody().getExpiration().before(new Date()) == false;
        }
        catch (Exception e){
            return false;
        }
    }
}
