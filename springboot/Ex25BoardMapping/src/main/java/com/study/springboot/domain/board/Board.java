package com.study.springboot.domain.board;

import com.study.springboot.domain.reply.Reply;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Entity, @Component : 기본생성자가 필요함. 없으면 자동생성
// fastxml ObjectMapper에서 Class정보를 이용하여 리플렉션을
// 할때 기본생성자로 생성함.
// 매개변수가 있는 생성자 : 매개변수의 정보를 알수 없기 때문에
// 자동생성 할 수 없다. 이게있다면 기본생성자을 강제로 만들어야 됨.
@Entity
@Table(name = "board")
@Getter
// new Board() 작성이 불가하여, 객체 일관성을 유지하기 좋다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx", nullable = false)
    private Long boardIdx;  //인덱스
    @Column(name = "board_name", nullable = false)
    private String boardName; //작성자
    @Column(name = "board_title", nullable = false)
    private String boardTitle; //글제목
    @Column(name = "board_content", nullable = false)
    private String boardContent; //글내용
    @Column(name = "board_hit", nullable = false)
    private Long boardHit; //조회수
    @Column(name = "board_date", nullable = false)
    private LocalDateTime boardDate = LocalDateTime.now(); //생성일시,수정일시

    //mappedBy : 연관관계 객체이름
    //cascade : 전이 - DB에 게시글이 생성될때 같이 생성되거나 삭제.
    //orphanRemoval : replies 리스트에서 삭제하면 DB에서도 삭제됨.
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replies = new ArrayList<>();

    //선택적 매개변수가 있는 생성자
    @Builder
    public Board(String boardName, String boardTitle,
                 String boardContent, Long boardHit) {
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
    }
    public void update(String boardName, String boardTitle,
                       String boardContent, Long boardHit) {
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
        this.boardDate = LocalDateTime.now(); //현재시간으로 업데이트
    }
    // JPA에서 Entity객체를 얻어오면, 값만 설정해도 자동으로 업데이트가 됨.
    public void updateHit(Long boardHit) {
        this.boardHit = boardHit;
    }
}








