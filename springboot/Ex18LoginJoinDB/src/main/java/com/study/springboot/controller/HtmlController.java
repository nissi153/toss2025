package com.study.springboot.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(){
        return "index";
    }
    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }
    @PostMapping("/loginAction")
    public String loginAction(){
        //DB에 member테이블에 userId, userPw를 가진 행을 찾는다.
        //session에 로그인 처리한다.
        return "index";
    }

    @GetMapping("/logoutAction")
    public String logoutAction(HttpSession session){
        session.invalidate();
        return "index";
    }

}
