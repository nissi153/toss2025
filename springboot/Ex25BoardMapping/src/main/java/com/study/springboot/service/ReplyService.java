package com.study.springboot.service;

import com.study.springboot.domain.board.Board;
import com.study.springboot.domain.board.BoardRepository;
import com.study.springboot.domain.reply.Reply;
import com.study.springboot.domain.reply.ReplyRepository;
import com.study.springboot.dto.ReplyResponseDto;
import com.study.springboot.dto.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    //특정 게시글(포스트)의 댓글 목록 조회
    @Transactional(readOnly = true)
    public List<ReplyResponseDto> findAllByBoardIdx(Long boardIdx){
        List<Reply> list = replyRepository.findAllByBoardBoardIdxOrderByReplyDateDesc( boardIdx );

        //List<Reply>를 List<DTO>로 변환 : stream()메소드
        return list.stream().map(ReplyResponseDto::new).collect(Collectors.toList());
    }
    @Transactional
    public void delete(Long replyIdx){
        Reply entity = replyRepository.findById(replyIdx)
                .orElseThrow( () -> new IllegalArgumentException("댓글 인덱스 오류입니다. replyIdx:"+replyIdx) );
        replyRepository.delete( entity) ;
    }
    @Transactional
    public Long save(final ReplySaveRequestDto dto){
        Board board = boardRepository.findById(dto.getReplyBoardIdx())
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. boardIdx:" + dto.getReplyBoardIdx()));
        
        Reply entity = dto.toEntity(board);
        return replyRepository.save(entity).getReplyIdx();
    }
    @Transactional(readOnly = true)
    public boolean existsById(final Long replyIdx) {
        boolean isFound = replyRepository.existsById( replyIdx );
        return isFound;
    }
}
