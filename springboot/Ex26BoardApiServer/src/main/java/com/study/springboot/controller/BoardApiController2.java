package com.study.springboot.controller;

import com.study.springboot.dto.BoardResponseDto;
import com.study.springboot.dto.BoardSaveRequestDto;
import com.study.springboot.dto.ReplyResponseDto;
import com.study.springboot.service.BoardService;
import com.study.springboot.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController2 {
    final private BoardService boardService;
    final private ReplyService replyService;

    //게시글 전체 조회
    @GetMapping("/boards")
    public ResponseEntity<List<BoardResponseDto>> findAll(){
        List<BoardResponseDto> list = boardService.findAll();
        return ResponseEntity.ok(list);
    }
    //게시글 단건 조회
    @GetMapping("/boards/{id}")
    public ResponseEntity<BoardResponseDto> findById(@PathVariable final Long id) {
        try{
            BoardResponseDto dto = boardService.findById( id );
            return ResponseEntity.ok(dto);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    //게시글 댓글 조회
    @GetMapping("/boards/{id}/replys")
    public ResponseEntity<List<ReplyResponseDto>> replys(@PathVariable final Long id){
        List<ReplyResponseDto> list = replyService.findAllByBoardIdx( id );
        return ResponseEntity.ok(list);
    }
    //게시글 추가
    @PostMapping("/boards")
    public ResponseEntity<BoardResponseDto> save(@RequestBody final BoardSaveRequestDto dto) {
        BoardResponseDto savedDto = boardService.saveToDto( dto );
        return ResponseEntity.status(HttpStatus.CREATED).body( savedDto );
    }
    //게시글 수정
    @PutMapping("/boards/{id}")
    public ResponseEntity<BoardResponseDto> update(@PathVariable final Long id,
                                   @RequestBody final BoardSaveRequestDto dto){
        try {
            BoardResponseDto updatedDto = boardService.updateToDto( id, dto );
            return ResponseEntity.ok(updatedDto);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    //게시글 삭제
    @DeleteMapping("/boards/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id){
        try {
            boardService.deleteToDto( id );
            return ResponseEntity.noContent().build(); //상태코드 204
        }catch (Exception e){
            return ResponseEntity.notFound().build(); //404
        }
    }
}









