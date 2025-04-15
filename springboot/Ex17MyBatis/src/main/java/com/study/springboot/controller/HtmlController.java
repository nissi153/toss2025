package com.study.springboot.controller;

import com.study.springboot.dao.IMemberDao;
import com.study.springboot.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HtmlController {
    //생성자 주입
    final IMemberDao memberDao;

    @GetMapping("/")
    public String main(){
        return "redirect:/list";
    }
    @GetMapping("/list")
    public String list(Model model){
        List<MemberDto> list = memberDao.list();
        model.addAttribute("list", list);
        int listcount = memberDao.count();
        model.addAttribute("listcount", listcount);
        return "index";
    }
    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }
    //Content-Type	                    처리 방식	어노테이션
    //application/x-www-form-urlencoded	폼 데이터	@ModelAttribute 또는 @RequestParam
    //application/json	                JSON 본문	@RequestBody
    @PostMapping("/joinAction")
    @ResponseBody
    //public String joinAction(@RequestParam String userId){
    public String joinAction(@ModelAttribute MemberDto dto){
        System.out.println("dto = " + dto.getUserId());

        try {
            int result = memberDao.insert(dto);
            System.out.println("result = " + result);
            if (result != 1) {
                return "<script>alert('회원가입실패');history.back();</script>";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "<script>alert('회원가입실패');history.back();</script>";
        }
        return "<script>alert('회원가입성공');location.href='/list';</script>";
    }
    @GetMapping("/viewMember")
    public String viewMember(@RequestParam int id, Model model) {
        Optional<MemberDto> optional = memberDao.findById( id );
        if( optional.isPresent() ){
            model.addAttribute( "member", optional.get() );
        } else {
            System.out.println("회원정보가 없습니다.");
            return "redirect:/list";
        }
        return "modifyForm";
    }
    @PostMapping("/modifyAction")
    @ResponseBody
    public String modifyAction(@ModelAttribute MemberDto dto){
        try{
            int result = memberDao.update( dto );
            if( result != 1 ){
                return "<script>alert('회원수정실패');history.back();</script>";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "<script>alert('회원수정실패');history.back();</script>";
        }
        return "<script>alert('회원수정성공');location.href='/list';</script>";
    }
    @GetMapping("/deleteMember")
    @ResponseBody
    public String deleteMember(@RequestParam int id){
        try{
            //int result = memberDao.delete( id );
            int result = memberDao.deleteMap( id, "su" );
            if( result != 1 ){
                return "<script>alert('회원삭제실패');history.back();</script>";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "<script>alert('회원삭제실패');history.back();</script>";
        }
        return "<script>alert('회원삭제성공');location.href='/list';</script>";
    }
}
