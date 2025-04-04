package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController : @Controller + @ResponseBody
@RestController
//@Controller
//@ResponseBody  // 클래스의 모든 응답이 문자열(JSON)으로 선언됨.
@RequestMapping("/api/v1")  //모든 경로가 /api/v1 부터 시작됨.
public class ApiController {
    //http://localhost:8080/api/v1/login
    @RequestMapping("/login")
    public String login(){
        return "login 함수 입니다.";
    }
}
