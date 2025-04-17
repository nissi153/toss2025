package com.study.springboot;

import lombok.Getter;
import lombok.Setter;

@Getter  //@RequestBody
@Setter
public class ReqDto {
    private String loginId;
    private String loginPw;
}
