package com.study.springboot;

import org.springframework.stereotype.Component;

//@Component : Spring F/W이 클래스를 자바 빈으로 생성해서 관리해줌.
//POJO : 순수한 자바 클래스
@Component
public class Member {
    private String name = "홍길동";
    //기본생성자 필수
    public Member() {
    }
    //Getter/Setter 필수
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
