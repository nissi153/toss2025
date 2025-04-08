package com.study.Pr01Counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    //필드 주입
    @Autowired
    private Counter counter;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("count", counter.getCount());
        return "index"; //index.html이 응답결과로 반환된다.
    }
    @GetMapping("/plus")
    public String plus(Model model){
        counter.setCount(counter.getCount() + 1);
        model.addAttribute("count", counter.getCount());
        return "index";
    }
    @GetMapping("/minus")
    public String minus(Model model){
        counter.setCount(counter.getCount() - 1);
        model.addAttribute("count", counter.getCount());
        return "index";
    }
}
