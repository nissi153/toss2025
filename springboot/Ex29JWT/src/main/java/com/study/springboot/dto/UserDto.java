package com.study.springboot.dto;

import com.study.springboot.enumeration.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private UserRole userRole;

    @Builder
    public UserDto(Long id, String email, String password, UserRole userRole) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

}
