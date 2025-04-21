package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(){
        return "upload";
    }
    @PostMapping("/upload")
    public String upload(){
        return "";
    }
}
