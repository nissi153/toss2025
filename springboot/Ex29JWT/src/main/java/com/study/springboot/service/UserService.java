package com.study.springboot.service;

import com.study.springboot.dto.UserDto;
import com.study.springboot.dto.UserRequestDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserRequestDto dto);
    UserDto findUser(String email);
    UserDto findByEmailAndPassword(String email, String password);
    List<UserDto> findAll();
}
