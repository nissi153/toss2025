package com.study.springboot.dto;

import com.study.springboot.enumeration.UserRole;
import lombok.Getter;
import lombok.Setter;

//signup, login 쿼리파라미터 매핑용
@Getter @Setter
public class UserRequestDto {
    private String email;
    private String password;
    private UserRole userRole;
}
