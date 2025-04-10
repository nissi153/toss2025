package com.study.springboot;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="member")
@Getter
//@Setter 비추천 - DB에 중복 적용됨.
@Builder  //객체생성시 사용 - 생성자함수 대체
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id")
    private String userId;
    @Column(name="user_pw")
    private String userPw;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_role")
    private String userRole;
    @Column
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate joindate;

    public void update(String userId, String userPw, String userName,
                       String userRole){
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userRole = userRole;
    }
}
