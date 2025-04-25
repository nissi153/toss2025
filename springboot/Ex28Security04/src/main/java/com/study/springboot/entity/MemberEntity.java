package com.study.springboot.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "member_security")
@Getter
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String user_name;
    private String user_role;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate join_date;

    @Builder
    public MemberEntity(Long id, String username, String password, String user_name, String user_role, LocalDate join_date) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.user_name = user_name;
        this.user_role = user_role;
        this.join_date = join_date;
    }
}
