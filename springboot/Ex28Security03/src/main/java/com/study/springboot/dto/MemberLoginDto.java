package com.study.springboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberLoginDto {
    @NotBlank(message = "username에 null, 빈문자열, 스페이스문자열만을 넣을 수 없습니다.")
    private String username;
    @NotBlank(message = "password에 null, 빈문자열, 스페이스문자열만을 넣을 수 없습니다.")
    private String password;
}
