package com.study.springboot.controller;

import com.study.springboot.dto.MemberSaveDto;
import com.study.springboot.entity.MemberEntity;
import com.study.springboot.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public String joinAction(@ModelAttribute MemberSaveDto dto){
        System.out.println("dto = " + dto.getUserId());
        try {
            MemberEntity entity = dto.toSaveEntity();
            memberRepository.save( entity );
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return "<script>alert('회원가입실패!');history.back();</script>";
        }
        System.out.println("회원가입 성공!");

        return "<script>alert('회원가입성공!');location.href='/';</script>";
    }

}
