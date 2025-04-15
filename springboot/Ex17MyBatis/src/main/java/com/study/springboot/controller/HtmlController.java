package com.study.springboot.controller;

import com.study.springboot.dao.IMemberDao;
import com.study.springboot.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
