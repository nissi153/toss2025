package com.study.springboot;

//@Repository : JPA DAO 클래스에 적용하고, @Component가 내부에 있음.
//@Service : 서비스 로직 클래스에 적용되고, @Component가 내부에 있음.
//@Controller : 컨트롤 인터페이스(HTTP 요청처리)를 구현하고,
//           @Component가 내부에 있음.

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository : 스프링 JPA 라이브러리에서 Entity에 대한 기본적인
//              : 조회, 삽입, 수정, 삭제가 가능하도록 만든 인터페이스이다.

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //JpaRepository의 기본함수
    //1. findAll() : SQL(Select * from Table)문을 실행한다.
    //2. findBy열이름() : SQL(Select 열이름 from Table)문을 실행한다.
    //  예) findById((long)2) : Select * from member where id=2;
    //  예) findByUser_id("hong") : Select * from member where user_id='hong';
    //3. save() : SQL의 insert문과 update문을 실행한다. id값을 보고 없으면 추가,
    //           있으면 수정한다.
    //4. delete() : SQL delete문을 수행한다.
}
