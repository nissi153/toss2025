package com.study.springboot.dto;

//                      @Controller @Service  @Repository
//html입력폼(react.js) <-> DTO <-> DTO <-> DAO(Repo) <-> DAO(Entity) <-> DB테이블
//  join form             JoinDto          IMemberRepo   MemberEntity    member
//  login form            LoginDto

import com.study.springboot.entity.MemberEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberJoinDto {
    @NotNull
    private Long id = Long.valueOf(0L);

    @Size(min=4, max=20, message = "아이디는 4자 이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String userId;

    @Size(min=4, max=20, message = "암호는 4자 이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String userPw;

    private String userName;

    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    @Pattern(regexp = "^(USER_ROLE|ADMIN_ROLE)$",
            message = "USER_ROLE 또는 ADMIN_ROLE만 입력 가능합니다.")
    private String userRole;
    private String userAddress; //입력폼에는 있고, Member테이블에 없는 정보.
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    //DTO -> Entity
    public MemberEntity toSaveEntity(){
        return MemberEntity.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }
    public MemberEntity toUpdateEntity(){
        return MemberEntity.builder()
                .id(id)
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }
}
