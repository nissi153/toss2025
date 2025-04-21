package com.study.springboot.controller;

import com.study.springboot.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String main(){
        return "redirect:/board/listForm";
    }
    @GetMapping("/listForm")
    public String listForm(){
        return "listForm";
    }


}






