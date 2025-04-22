package com.study.springboot.controller;


import com.study.springboot.dto.BoardResponseDto;
import com.study.springboot.dto.BoardSaveRequestDto;
import com.study.springboot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String listForm(Model model){
        List<BoardResponseDto> list = boardService.findAll();
        model.addAttribute("list", list);
        return "listForm";
    }
    @GetMapping("/writeForm")
    public String writeForm(){
        return "writeForm";
    }
    // Request Parameter를 가져올때
    //1. @RequestParam
    //  - 클래스 객체 매핑 : jacson라이브러리 - 기본생성자, Setter필요
    //  - 맵(map) 매핑
    //HTML Form태그의 값을 받아오는 방법
    //1. @ModelAttribute : x-www-form-urlencoded 형식의 폼 데이터를 처리할 때
    //HTTP Body(JS)의 값을 값을 받아오는 방법
    //1. @RequestBody
    @PostMapping("/writeAction")
    @ResponseBody
    public String writeAction(@ModelAttribute BoardSaveRequestDto dto){
        Long newIdx = boardService.save( dto );

        boolean isFound = boardService.existsById( newIdx );
        if( isFound == true ) {
            return "<script>alert('글쓰기 성공'); location.href='/board/listForm';</script>";
        }else{
            return "<script>alert('글쓰기 실패'); history.back();</script>";
        }
    }
    @GetMapping("/contentForm")
    public String contentForm(@RequestParam Long boardIdx, Model model){
        //게시글 단건 조회
        BoardResponseDto dto = boardService.findById( boardIdx );
        model.addAttribute( "dto", dto);

        return "contentForm";
    }
}






