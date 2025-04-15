package com.study.springboot.controller;

import com.study.springboot.dao.IMemberDao;
import com.study.springboot.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("listcount", list.size());
        return "index";
    }

}
