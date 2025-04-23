package com.study.springboot.dto;

import com.study.springboot.domain.reply.Reply;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyResponseDto {
    private Long replyIdx;
    private String replyName;
    private String replyContent;
    private LocalDateTime replyDate;
    private Long boardIdx;

    // Entity to DTO
    public ReplyResponseDto(Reply entity){
        this.replyIdx = entity.getReplyIdx();
        this.replyContent = entity.getReplyContent();
        this.replyName = entity.getReplyName();
        this.replyDate = entity.getReplyDate();
        this.boardIdx = entity.getBoard().getBoardIdx();
    }
}
