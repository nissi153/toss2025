package com.study.springboot.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SnsUserRepository extends JpaRepository<SnsUser, Long> {
    //SNS 로그인으로 반환되는 값중에서 email을 통해
    //이미 생성된 사용자인지, 처음가입하는 사용자인지 구분하기 위한 메소드
    Optional<SnsUser> findByEmail(String email);
}
