package com.study.springboot;

import lombok.Getter;

@Getter
public enum UserRole {
    //스프링 시큐리티의 권한 코드는 항상 "ROLE_" 로 시작해야합니다
    //hasRole(String) : 사용자가 주어진 역할이 있다면 접근을 허용 (인가)
    //hasAuthority(String) : 사용자가 주어진 권한이 있다면 접근을 허용 (인증)
    //예) hasRole("USER")
    //예) hasAuthority("ROLE_USER")

    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

    private String value;

    UserRole(String value){
        this.value = value;
    }
}
