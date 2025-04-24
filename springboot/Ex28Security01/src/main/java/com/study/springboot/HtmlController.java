package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HtmlController {
    @GetMapping("/")
    @ResponseBody
    public String main(){
        return "스프링 시큐리티 앱입니다.";
    }
    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }
}
