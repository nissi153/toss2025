package com.study.springboot.controller;


import com.study.springboot.dto.AuthResponseDTO;
import com.study.springboot.security.CustomUserDetails;
import com.study.springboot.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 카카오 로그인 콜백 처리
    @PostMapping("/kakao/callback")
    public ResponseEntity<AuthResponseDTO> kakaoCallback(@RequestBody Map<String, String> request) {
        String code = request.get("code");

        // 디버깅을 위한 로그 추가
        log.info("Received authorization code: {}", code);

        AuthResponseDTO response = authService.kakaoLogin(code);
        return ResponseEntity.ok(response);
    }

    // 토큰 갱신
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponseDTO> refreshToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");
        AuthResponseDTO response = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(response);
    }

    // 토큰 유효성 검증
    @GetMapping("/validate")
    public ResponseEntity<Map<String, Boolean>> validateToken(@RequestHeader("Authorization") String bearerToken) {
        String token = bearerToken.substring(7);
        try {
            authService.validateToken(token);
            return ResponseEntity.ok(Map.of("valid", true));
        } catch (Exception e) {
            return ResponseEntity.ok(Map.of("valid", false));
        }
    }

    // 현재 사용자 정보 조회
    @GetMapping("/me")
    public ResponseEntity<AuthResponseDTO.UserDTO> getCurrentUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
        AuthResponseDTO.UserDTO userDTO = authService.getCurrentUser(userDetails.getId());
        return ResponseEntity.ok(userDTO);
    }
}