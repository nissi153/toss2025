package com.study.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //JPA 기본함수
    //1. findAll
    //2. findById
    //3. count()
    //4. save()
    //5. delete()
}
