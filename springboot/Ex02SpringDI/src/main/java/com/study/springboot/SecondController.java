package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecondController {
    @GetMapping("/login")
    @ResponseBody
    public String login(){
        return "로그인 처리...";
    }
}
