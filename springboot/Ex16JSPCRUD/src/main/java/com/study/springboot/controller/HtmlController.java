package com.study.springboot.controller;

import com.study.springboot.dto.MemberSaveDto;
import com.study.springboot.entity.MemberEntity;
import com.study.springboot.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //viewMember?id=1
    @GetMapping("/viewMember")
    public String viewMember(@RequestParam("id") Long id, Model model){
        System.out.println("id = " + id);

        Optional<MemberEntity> optional = memberRepository.findById(id);
        if( !optional.isPresent() ) {
            return "redirect:/list";
        }

        optional.ifPresent( (entity)->{
            model.addAttribute("member", entity.toSaveDto());
        });

        return "modifyForm";
    }
    @PostMapping("/modifyAction")
    @ResponseBody
    public String modifyAction(@ModelAttribute MemberSaveDto dto){
        try{
            MemberEntity entity = dto.toSaveEntity();
            memberRepository.save( entity );
        }
        catch (Exception e){
            e.printStackTrace();
            return "<script>alert('회원정보수정실패');history.back();</script>";
        }

        return "<script>alert('회원정보수정성공');location.href='/';</script>";
    }
    @GetMapping("/deleteMember")
    @ResponseBody
    public String deleteMember(@RequestParam("id") Long id){
        Optional<MemberEntity> optional = memberRepository.findById(id);
        if(!optional.isPresent()){
            return "<script>alert('회원정보삭제실패');history.back();</script>";
        }
        MemberEntity entity = optional.get(); //unwrapping한다.
        try{
            memberRepository.delete(entity);
        }
        catch (Exception e){
            e.printStackTrace();
            return "<script>alert('회원정보삭제실패');history.back();</script>";
        }

        return "<script>alert('회원정보삭제성공');location.href='/';</script>";
    }
}
