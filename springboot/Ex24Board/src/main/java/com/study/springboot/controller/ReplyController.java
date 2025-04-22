package com.study.springboot.controller;

import com.study.springboot.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    //  "/reply/deleteAction?replyIdx=4&boardIdx=1"
    @GetMapping("/deleteAction")
    @ResponseBody
    public String deleteAction(@RequestParam Long replyIdx,
                               @RequestParam Long boardIdx){
        replyService.delete( replyIdx );

        return "<script>alert('댓글삭제 성공'); location.href='/board/contentForm?boardIdx="+ boardIdx +"';</script>";
    }


}
