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
public class BoardService {
    private final BoardRepository boardRepository;

    //@Transactional
    //JPA를 사용한다면, 서비스(Service) 클래스에서 필수적으로 사용되어야 하는 어노테이션입니다.
    //일반적으로 메서드 레벨에 선언하게 되며, 메서드의 실행, 종료, 예외를 기준으로
    //각각 실행(begin), 종료(commit), 예외(rollback)를 자동으로 처리해 줍니다.
    // Transaction : 일련의 작업의 단위(단일작업의 모음-Select, Update, Insert, Delete, Drop, Alter)
    // 트랜잭션 시작 : 일련의 작업의 시작
    // 트랜잭션 종료 : 일련의 작업의 종료(커밋 발생 - 물리DB에 적용)
    // 트랜잭션 예외 : 일련의 작업중 예외발생(로백 발생 - 처음 작업시작전 상태로 되돌림)
    // 예) 은행 송금 처리(하나의 트랜잭션)
    //    1. A계좌 : 1000원 감소  -> 성공
    //    2. B계좌 : 1000원 증가  -> 통신오류!
    //    3. 송금 내역 저장

    //@Transactional : find(select) 생략가능, insert, update, delete 반드시 기술해야 됨.

    //전체목록보기
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "boardDate", "boardIdx");
        List<Board> list = boardRepository.findAll( sort );

        //List<Board>를 List<BoardResponseDto>로 변환 : stream() 메소드 사용
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }
    @Transactional // begin(), close()
    public Long save(final BoardSaveRequestDto dto){
        //persist(), commit(), rollback()
        Board entity = boardRepository.save( dto.toEntity() );
        return entity.getBoardIdx();
    }
    @Transactional(readOnly = true)
    public boolean existsById(Long boardIdx){
        boolean isFound = boardRepository.existsById( boardIdx );
        return isFound;
    }
    @Transactional(readOnly = true)
    public BoardResponseDto findById( Long boardIdx){
        Board entity = boardRepository.findById( boardIdx )
                .orElseThrow( ()->
                        new IllegalArgumentException( "없는 글인덱스입니다. boardIdx:"+boardIdx) );

        return new BoardResponseDto(entity);
    }
    @Transactional
    public void updateHit(final Long boardIdx, final Long hit){
        Board entity = boardRepository.findById( boardIdx )
                .orElseThrow( ()->
                        new IllegalArgumentException( "없는 글인덱스입니다. boardIdx:"+boardIdx) );
        //엔티티 클래스의 필드(멤버변수)값만 바꿔도 자동으로 저장된다. save() 별도로 호출안해도 됨.
        entity.updateHit( hit );
        //트랜잭션 함수를 벗어날때 자동 update, commit이 된다.
    }
    @Transactional
    public boolean update(final Long boardIdx, final BoardSaveRequestDto dto){
        Board entity = boardRepository.findById( boardIdx )
                .orElseThrow( ()->
                        new IllegalArgumentException( "없는 글인덱스입니다. boardIdx:"+boardIdx) );

        entity.update(dto.getBoardName(), dto.getBoardTitle(),
                      dto.getBoardContent(), dto.getBoardHit());

        return true;
    }
    @Transactional
    public void delete(final Long boardIdx) {
        Board entity = boardRepository.findById( boardIdx )
                .orElseThrow( ()->
                        new IllegalArgumentException( "없는 글인덱스입니다. boardIdx:"+boardIdx) );
        boardRepository.delete( entity );
    }

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long emTest(final BoardSaveRequestDto dto){

        //Board entity = boardRepository.save( dto.toEntity() );

        Board entity = dto.toEntity();
        em.persist(entity); // 직접 persist 호출

        return entity.getBoardIdx();
    }
}



