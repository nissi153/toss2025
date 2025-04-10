package com.study.springboot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest : 테스트환경을 기본설정해주는 어노테이션
@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @BeforeAll //static메소드, 모든 테스트 케이스 전에 호출
    static void setup(){
        System.out.println("@BeforeAll");
    }
    @BeforeEach //@Test 메소드 호출시만다 한번 수행
    void init(){
        System.out.println("@BeforeEach");

        save(); //레코드 추가
    }
    @Test //테스트 메소드(단위 테스트)
    @DisplayName("save 테스트")
    public void save() {
        System.out.println("save()");

        memberRepository.save(
            new MemberEntity(null, "hong", "1234", "홍길동", "ROLE_USER",
                    LocalDate.parse("2025-04-10")));
        memberRepository.save(
                new MemberEntity(null, "tom", "1234", "톰아저씨", "ROLE_USER",
                        LocalDate.parse("2025-04-10")));
        memberRepository.save(
                new MemberEntity(null, "admin", "1234", "관리자", "ROLE_USER",
                        LocalDate.parse("2025-04-10")));

        List<MemberEntity> list = memberRepository.findAll();

        //단정함수(Assert Function)
        //assertEquals( 3, list.size() );

    }
    @Test
    @DisplayName("findById 테스트")
    public void findById() {
        // id가 1인 행을 검색(select)하여 행(레코드) 정보를 가져온다.
        Optional<MemberEntity> optional = memberRepository.findById(100L);
        optional.ifPresent( unwrapped -> {
            //null이 아닐 때 호출되는 람다식
            System.out.println("unwrapped. = " + unwrapped.getUserName() );
            assertEquals("홍길동", unwrapped.getUserName());
        } );
        optional.ifPresentOrElse( (unwrapped) -> {
            //null이 아닐 때 호출되는 람다식
            System.out.println("unwrapped. = " + unwrapped.getUserName() );
            assertEquals("홍길동", unwrapped.getUserName());
        }, () -> fail("member 엔티티가 null입니다.") );
    }


}