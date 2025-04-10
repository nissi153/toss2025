package com.study.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    //생성자 주입
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String main(Model model){
        List<MemberEntity> list = memberRepository.findAll(); //Select * from member;
        model.addAttribute("list", list);
        return "index";
    }
}
