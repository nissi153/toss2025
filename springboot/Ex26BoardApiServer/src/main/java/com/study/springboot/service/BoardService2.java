package com.study.springboot.service;

import com.study.springboot.domain.board.Board;
import com.study.springboot.domain.board.BoardRepository;
import com.study.springboot.dto.BoardResponseDto;
import com.study.springboot.dto.BoardSaveRequestDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService2 {
    private final BoardRepository boardRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll() {
        //tx.begin()
        String jpql = "SELECT b FROM Board b ORDER BY b.boardDate DESC, b.boardIdx DESC";
        List<Board> list = em.createQuery(jpql, Board.class).getResultList();
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
        //tx.commit() rollback()
        //em.close()
        //emf.close()
    }
    @Transactional
    public Long save(final BoardSaveRequestDto dto){
        Board entity = dto.toEntity();
        em.persist( entity );
        return entity.getBoardIdx();
    }
    @Transactional(readOnly = true)
    public boolean existsById(Long boardIdx){
        Board entity = em.find(Board.class, boardIdx);
        return entity != null;
    }
    @Transactional(readOnly = true)
    public BoardResponseDto findById( Long boardIdx){
        Board entity = em.find( Board.class, boardIdx );
        if( entity == null ){
            throw new IllegalArgumentException( "없는 글인덱스입니다. boardIdx:"+boardIdx);
        }
        return new BoardResponseDto(entity);
    }
    @Transactional
    public void updateHit(final Long boardIdx, final Long hit) {
        Board entity = em.find(Board.class, boardIdx);
        if (entity == null) {
            throw new IllegalArgumentException("없는 글인덱스입니다. boardIdx:" + boardIdx);
        }
        entity.updateHit(hit);
    }
    @Transactional
    public boolean update(final Long boardIdx, final BoardSaveRequestDto dto){
        Board entity = em.find(Board.class, boardIdx);
        if (entity == null) {
            throw new IllegalArgumentException("없는 글인덱스입니다. boardIdx:" + boardIdx);
        }
        entity.update(dto.getBoardName(), dto.getBoardTitle(),
                dto.getBoardContent(), dto.getBoardHit());
        return true;
    }
    @Transactional
    public void delete(final Long boardIdx) {
        Board entity = em.find( Board.class, boardIdx );
        if( entity == null ) {
            throw new IllegalArgumentException("없는 글인덱스입니다. boardIdx:" + boardIdx);
        }
        em.remove( entity );
    }

}



