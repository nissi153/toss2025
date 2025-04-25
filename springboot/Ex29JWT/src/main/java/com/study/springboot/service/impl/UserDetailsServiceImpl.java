package com.study.springboot.service.impl;

import com.study.springboot.entity.UserRepository;
import com.study.springboot.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public Users loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Users usersEntity = Optional.ofNullable(
                userRepository.findByEmail(userEmail)).orElseThrow(
                () -> new BadCredentialsException("이메일에 맞는 회원 정보를 찾을 수 없습니다.")
        );
        return usersEntity;
    }
}
