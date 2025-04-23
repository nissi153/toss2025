package com.study.springboot.domain.reply;

import com.study.springboot.domain.board.Board;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_idx", nullable = false)
    private Long replyIdx;
    @Column(name = "reply_name", nullable = false)
    private String replyName; //작성자 별명
    @Column(name = "reply_content", nullable = false)
    private String replyContent; //내용
    @Column(name = "reply_date", nullable = false)
    private LocalDateTime replyDate = LocalDateTime.now();

//    @Column(name = "reply_board_idx", nullable = false)
//    private Long replyBoardIdx; //외래키 FK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_board_idx", nullable = false)
    private Board board;

    @Builder
    public Reply(String replyName, String replyContent, Board board){
        this.replyName = replyName;
        this.replyContent = replyContent;
        this.board = board;
    }
    public void update(String replyName, String replyContent) {
        this.replyName = replyName;
        this.replyContent = replyContent;
        this.replyDate = LocalDateTime.now();
    }
}
