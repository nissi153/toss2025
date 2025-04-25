package com.study.springboot.controller;

import com.study.springboot.config.JwtUtil;
import com.study.springboot.dto.UserDto;
import com.study.springboot.dto.UserRequestDto;
import com.study.springboot.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class ApiController {
    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public UserDto createUser(@ModelAttribute UserRequestDto dto) {
        return userService.createUser(dto);
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserRequestDto userRequest)  {
        UserDto users = userService.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
        return jwtUtil.createToken(users.getEmail(), Arrays.asList(users.getUserRole().getValue()));
    }

//    @RolleAllowed({"ROLE_USER", "ROLE_ADMIN"}) //표준 보안 생태계
//    public void userOrAdminMethod() {
//        // 사용자 또는 관리자가 접근 가능한 메서드
//    }

    @GetMapping("/my")  //스프링 시큐리티의 현재 세션(인증) 정보를 주입받음.
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public UserDto findUser(Authentication authentication) {
        if (authentication == null) {
            throw new BadCredentialsException("회원 정보를 찾을 수 없습니다.");
        }
        return userService.findUser(authentication.getName());
    }

    @GetMapping("/admin")
    @PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
    public List<UserDto> findAllUser() {
        return userService.findAll();
    }


}
