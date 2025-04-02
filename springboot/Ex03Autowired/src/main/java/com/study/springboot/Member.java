package com.study.springboot;

import org.springframework.stereotype.Component;

@Component("member")  //빈의 이름을 직접 지정 가능
public class Member {
    private String name;
    private ICard iCard;

    //기본생성자
    public Member(){ }
    //매개변수 생성자
    public Member(ICard iCard, String name) {
        this.iCard = iCard;
        this.name = name;
    }
    //Getter/Setter
    public ICard getiCard() {
        return iCard;
    }

    public void setiCard(ICard iCard) {
        this.iCard = iCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
