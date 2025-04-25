package com.study.springboot.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    //쿼리 메소드 정의
    Users findByEmail(String email);
    Users findByEmailAndPassword(String email, String password);
}
