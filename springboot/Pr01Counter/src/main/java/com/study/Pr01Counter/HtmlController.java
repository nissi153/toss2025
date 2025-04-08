package com.study.Pr01Counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    //필드 주입
    @Autowired
    private Counter counter;

    @GetMapping("/")
    public String main(){
        System.out.println("counter.getCount() = " + counter.getCount());
        
        return "index"; //index.html이 응답결과로 반환된다.
    }
}
