package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(){
        return "ex01"; // ex01.jsp을 html 응답한다.
    }
    //url : localhost:8080/ex/02
    @GetMapping("/ex/{no}")
    public String ex(@PathVariable String no, Model model){
        model.addAttribute("name", "홍길동");
        return "ex" + no; // ex02.jsp 응답
    }
}
