package com.study.springboot.dto;

import com.study.springboot.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String boardName;
    private String boardTitle;
    private String boardContent;
    private Long boardHit;

    @Builder
    public BoardSaveRequestDto(String boardName, String boardTitle,
                            String boardContent, Long boardHit){
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
    }
    // DTO to Entity
    public Board toEntity(){
        return Board.builder()
                .boardName(boardName)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .boardHit(boardHit)
                .build();
    }
}
