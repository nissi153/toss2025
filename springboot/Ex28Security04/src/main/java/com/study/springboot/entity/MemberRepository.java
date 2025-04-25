package com.study.springboot.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    @Query(value = "select * from member_security m where m.username = :username_param and m.password = :password_param", nativeQuery = true)
    List<MemberEntity> findByUserIdAndUserPw(@Param("username_param") String username,
                                             @Param("password_param") String password);

    @Query(value = "select * from member_security m where m.username = :username_param", nativeQuery = true)
    Optional<MemberEntity> findByUserId(@Param("username_param") String username);

}
