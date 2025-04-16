package com.study.stringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String first(){
        return "first";
    }
    @GetMapping("/second")
    public String second(){
        return "second";
    }
}
