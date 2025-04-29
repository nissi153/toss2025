package com.study.springboot.service;


import com.study.springboot.dto.AuthResponseDTO;
import com.study.springboot.dto.KakaoDTO;
import com.study.springboot.entity.User;
import com.study.springboot.repository.UserRepository;
import com.study.springboot.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final KakaoService kakaoService;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public AuthResponseDTO kakaoLogin(String code) {
        // 카카오 인가 코드로 액세스 토큰 요청
        KakaoDTO.TokenResponse tokenResponse = kakaoService.getKakaoTokenInfo(code);

        // 액세스 토큰으로 카카오 사용자 정보 요청
        KakaoDTO.KakaoProfile profile = kakaoService.getKakaoProfile(tokenResponse.getAccessToken());

        // 카카오 ID로 사용자 조회 또는 생성
        User user = getUserFromKakaoProfile(profile);

        // JWT 토큰 생성
        String accessToken = jwtTokenProvider.createAccessToken(user);
        String refreshToken = jwtTokenProvider.createRefreshToken(user);

        // 리프레시 토큰 저장
        user.setRefreshToken(refreshToken);
        userRepository.save(user);

        // 응답 DTO 생성
        return createAuthResponse(user, accessToken, refreshToken);
    }

    private User getUserFromKakaoProfile(KakaoDTO.KakaoProfile profile) {
        // 기존 사용자 조회
        Optional<User> existingUser = userRepository.findByKakaoId(profile.getId());

        if (existingUser.isPresent()) {
            return existingUser.get();
        }

        // 새 사용자 생성
        User newUser = User.builder()
                .kakaoId(profile.getId())
                .email(profile.getKakaoAccount().getEmail())
                .name(profile.getKakaoAccount().getProfile().getNickname())
                .profileImage(profile.getKakaoAccount().getProfile().getProfileImageUrl())
                .roles(new HashSet<>(Collections.singleton("ROLE_USER")))
                .build();
        
        return userRepository.save(newUser);
    }

    private AuthResponseDTO createAuthResponse(User user, String accessToken, String refreshToken) {
        return AuthResponseDTO.builder()
                .token(accessToken)
                .refreshToken(refreshToken)
                .user(AuthResponseDTO.UserDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .profileImage(user.getProfileImage())
                        .build())
                .build();
    }

    @Transactional
    public AuthResponseDTO refreshToken(String refreshToken) {
        // 리프레시 토큰 유효성 검증
        if (!jwtTokenProvider.validateToken(refreshToken)) {
            throw new RuntimeException("유효하지 않은 리프레시 토큰입니다.");
        }

        // 토큰에서 이메일 추출
        String email = jwtTokenProvider.getEmailFromToken(refreshToken);

        // 사용자 조회
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        // 저장된 리프레시 토큰과 일치하는지 확인
        if (!user.getRefreshToken().equals(refreshToken)) {
            throw new RuntimeException("리프레시 토큰이 일치하지 않습니다.");
        }

        // 새 액세스 토큰 생성
        String newAccessToken = jwtTokenProvider.createAccessToken(user);

        // 응답 DTO 생성
        return AuthResponseDTO.builder()
                .token(newAccessToken)
                .refreshToken(refreshToken) // 리프레시 토큰은 그대로 유지
                .user(AuthResponseDTO.UserDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .profileImage(user.getProfileImage())
                        .build())
                .build();
    }

    public AuthResponseDTO validateToken(String token) {
        boolean isValid = jwtTokenProvider.validateToken(token);

        if (!isValid) {
            throw new RuntimeException("유효하지 않은 토큰입니다.");
        }

        // 토큰에서 사용자 ID 추출
        Long userId = jwtTokenProvider.getIdFromToken(token);

        // 사용자 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        // 응답 DTO 생성 (토큰은 그대로 유지, 리프레시 토큰은 포함하지 않음)
        return AuthResponseDTO.builder()
                .token(token)
                .user(AuthResponseDTO.UserDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .profileImage(user.getProfileImage())
                        .build())
                .build();
    }

    public AuthResponseDTO.UserDTO getCurrentUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        return AuthResponseDTO.UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .profileImage(user.getProfileImage())
                .build();
    }
}
