package com.study.springboot.dto;

import com.study.springboot.domain.board.Board;
import com.study.springboot.domain.board.BoardRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.GenericDeclaration;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {
    private Long boardIdx;
    private String boardName;
    private String boardTitle;
    private String boardContent;
    private Long boardHit;
    private LocalDateTime boardDate;

    //entity -> dto
    public BoardResponseDto(Board entity){
        this.boardIdx = entity.getBoardIdx();
        this.boardName = entity.getBoardName();
        this.boardTitle = entity.getBoardTitle();
        this.boardContent = entity.getBoardContent();
        this.boardHit = entity.getBoardHit();
        this.boardDate = entity.getBoardDate();
    }
}
