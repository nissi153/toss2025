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
        return "index";
    }

    @GetMapping("/logoutAction")
    public String logoutAction(HttpSession session){
        session.invalidate();
        return "index";
    }

}
