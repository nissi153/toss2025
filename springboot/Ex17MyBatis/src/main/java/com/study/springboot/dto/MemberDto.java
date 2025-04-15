package com.study.springboot.dto;

// html입력폼(post) <-> DTO <-> DAO(Entity) <-> Mapper XML(Repo인터페이스) <-> DB

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {  //DB 필드와 1:1로 매칭됨.
    private Long id;
    private String userId;
    private String userPw;
    private String userName;
    private String userRole;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;
}
