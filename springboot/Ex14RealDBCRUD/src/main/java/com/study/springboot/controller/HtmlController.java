package com.study.springboot.controller;

import com.study.springboot.dto.MemberSaveDto;
import com.study.springboot.entity.MemberEntity;
import com.study.springboot.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HtmlController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String main(Model model) {
        List<MemberEntity> list =
                memberRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("listcount", list.size());
        return "index";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/joinAction")
    public String joinAction(@ModelAttribute MemberSaveDto dto){
        System.out.println("dto = " + dto.getUserId());
        return "index";
    }

}
