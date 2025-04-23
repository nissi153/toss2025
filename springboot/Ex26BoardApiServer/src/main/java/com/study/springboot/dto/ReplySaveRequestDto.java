package com.study.springboot.dto;

import com.study.springboot.domain.reply.Reply;
import com.study.springboot.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ReplySaveRequestDto {
    private String replyName;
    private String replyContent;
    private Long replyBoardIdx; //외래키

    @Builder
    public ReplySaveRequestDto(String replyName, String replyContent,
                               Long replyBoardIdx) {
        this.replyName = replyName;
        this.replyContent = replyContent;
        this.replyBoardIdx = replyBoardIdx;
    }
    // DTO to Entity
    public Reply toEntity(Board board){
        return Reply.builder()
                .replyName(replyName)
                .replyContent(replyContent)
                .board(board)
                .build();
    }
}
