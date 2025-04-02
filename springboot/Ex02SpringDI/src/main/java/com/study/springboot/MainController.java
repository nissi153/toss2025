package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller : HTTP 요청을 처리하는 컨트롤 클래스이다.
//               GET/POST/PUT/DELETE 요청을 처리한다.
@Controller
public class MainController {
    // localhost:8090
    @GetMapping("/") // GET요청을 처리하는 메소드 위에 선언한다.
    @ResponseBody  //응답을 html로 하지 않고, Body데이터(문자열)로 처리한다.
    public String main() {
        return "스프링부트 서버가 준비되었습니다.";
    }
    // localhost:8090/test
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "테스트입니다.";
    }

    //사용자 정의 빈을 주입받는 방법 3가지
    //1. 필드 주입
    @Autowired
    private Member member1; // = new Member()
    @Autowired   //필드마다 따로 선언해야 됨.
    private Member member2;

    @GetMapping("/field")
    @ResponseBody
    public String field() {
        System.out.println("member1 = " + member1);
        System.out.println("member2 = " + member2);
        return "field() 호출됨.";
    }

    //2. 수정자 주입
    private Member member3;
    @Autowired
    public void setMember(Member member) {
        this.member3 = member;
    }
    @GetMapping("/setter")
    @ResponseBody
    public String setter() {
        System.out.println("member3 = " + member3);
        return "setter() 호출됨";
    }

    //3. 생성자 주입 - 권장
    // 1) final 키워드 사용가능(객체 재할당 방법)
    // 2) 생성자로서 미리 주입을 우선적으로 받을 수 있다. null safety 제공
    private final Member member4;
    @Autowired
    public MainController(Member member) {
        System.out.println("생성자 주입됨");
        this.member4 = member;
    }
    @GetMapping("/constructor")
    @ResponseBody
    public String constructor() {
        System.out.println("member4 = " + member4);
        return "constructor() 호출됨";
    }

}
