package com.study.springboot;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //JpaRepository의 기본함수
    //1. findAll() : SQL(Select * from Table)문을 실행한다.
    //2. save() : SQL의 insert문과 update문을 실행한다. id값을 보고 없으면 추가,
    //           있으면 수정한다.
    //3. delete() : SQL delete문을 수행한다.

    //사용자 정의 JPA 함수들을 추가해서 사용한다.
    //1. 쿼리메소드
    //findBy열이름() : SQL - select 열이름 from 테이블 문으로 실행
    //  예) findById(2L) : select * from member where id=2
    //  예) findByUserId("hong") : select * from where user_id='hong'
//    List<MemberEntity> findByUserId(String userId);
    Optional<MemberEntity> findByUserId(String userId);

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
    // - 특정 DBMS에 종속적인 기능을 제공한다.
    //   예) MySQL : LIMIT 5, now(), AUTO_INCREMENT
    //       Oracle : sysdate, sequence
    // Update, Insert, Delete문은 @Modifying, @Transaction을 추가해야 됨.
    @Query(value = "SELECT * FROM member WHERE user_id = :userid",
            nativeQuery = true)
    List<MemberEntity> findByUserId_Native(@Param("userid") String userid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE member SET user_id = :userid WHERE id = :id",
            nativeQuery = true)
    int updateById_Native(@Param("id") Long id, @Param("userid") String userid);

    //연습문제
    // JPA 메소드 쿼리
    //1. member 테이블 안에 암호가 "1234"인 회원이 있는지 테스트 하시오.
    Boolean existsByUserPw(String userpw);
    //2. 23년도 3월에 가입한 회원의 수가 1인지 테스트하시오.
    Boolean existsByJoindateBetween(LocalDate start, LocalDate end);
    //3. "lee"라는 아이디로 회원가입하고자 할때, 아이디 중복인지 테스트하시오.
    Boolean existsByUserId(String userpw);
    // JPQL or NativeQuery
    //4. "tom"이라는 아이디의 회원정보를 수정하고, 잘 수정되었는지 테스트하시오.
    //    톰아저씨 -> 마이클, 암호 -> 3456
    @Modifying
    @Transactional
    @Query(value = "UPDATE member SET user_name = :username, user_pw = :userpw" +
                   " WHERE user_id = :userid", nativeQuery = true )
    int updateByUserId_Native(@Param("userid") String userid, @Param("username") String username, @Param("userpw") String userpw);
}
