package com.study.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //HTTP 요청처리하는 클래스
@RequiredArgsConstructor  //final인 필드를 매개변수로 한 생성자 함수 생성한다.
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String main(){
        System.out.println("member1.getAge() = " + member1.getAge());
        System.out.println("member2.getAge() = " + member2.getAge());
        return "롬복 예제 서버입니다.";
    }
    //1.필드 주입
    @Autowired
    private Member member1;
    
    //2.생성자 주입
    private final Member member2;
//    @Autowired
//    public MainController(Member member){
//        this.member2 = member;
//    }
}
