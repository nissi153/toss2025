package com.study.springboot;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
//1. springframework의 @Value
// 1) application의 설정값을 주입하는 용도

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Value ("${my.username}")
    String username;
    @Value("${my.password}")
    String password;
}
