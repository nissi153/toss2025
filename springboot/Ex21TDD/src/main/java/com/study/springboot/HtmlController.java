package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String main(Model model, MemberDto dto){
        dto.setLoginId("hong");
        dto.setLoginPw("1234");
        model.addAttribute("member", dto);

        List<String> list = new ArrayList<>();
        list.add("hong");
        list.add("lee");
        model.addAttribute("list", list);

        return "index";
    }
}
