package com.study.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //JpaRepository의 기본함수
    //1. findAll() : SQL(Select * from Table)문을 실행한다.
    //2. save() : SQL의 insert문과 update문을 실행한다. id값을 보고 없으면 추가,
    //           있으면 수정한다.
    //3. delete() : SQL delete문을 수행한다.

    //사용자 정의 JPA 함수들을 추가해서 사용한다.
    //쿼리메소드
    //findBy열이름() : SQL - select 열이름 from 테이블 문으로 실행
    //  예) findById(2L) : select * from member where id=2
    //  예) findByUserId("hong") : select * from where user_id='hong'
    List<MemberEntity> findByUserId(String userId);

    List<MemberEntity> findFirst5ByUserIdAndUserNameOrderByIdDesc(
            String userid, String username
    );

    Boolean existsByJoindateLessThanEqual(LocalDate date);
    long countByUserNameIgnoreCaseLike(String username);

    //JPA에서 SQL을 사용할 방법
    //1. JPQL
    //   - 표준 ANSI SQL을 지원한다.
    //   - 특정 데이터베이스에 종속적이지 않다.
    //   - from절 뒤에는 엔티티 클래스이름을 넣어준다.(소문자로 하면 에러)
    @Query(value = "SELECT m FROM MemberEntity m WHERE m.userId = :userid")
    List<MemberEntity> findByUserId_JPQL(@Param("userid") String userid);

    //2. Native SQL
}
