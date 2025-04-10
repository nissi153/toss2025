package com.study.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //Jpa 기본함수들 findAll, save, delete
    //사용자 정의 JPA 함수들을 추가해서 사용한다.

}
