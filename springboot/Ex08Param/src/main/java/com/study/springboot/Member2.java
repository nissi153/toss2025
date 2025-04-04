package com.study.springboot;

import lombok.*;

//lombok의 @Value
// final, private, getter, equals, toString 이 자동 생성됨.
// setter가 빠짐.

@Value
public class Member2 {
    String username;
    String password;
}
