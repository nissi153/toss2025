package com.study.springboot.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository
    extends JpaRepository<MemberEntity, Long> {
    //기본 메소드
    //findAll, count, save, delete

    //사용자정의 메소드(JPA함수, JPQL, NativeQuery)
    Optional<MemberEntity> findByUserId(String userId);
    Optional<MemberEntity> findByUserPw(String userPw);
}
