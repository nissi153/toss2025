package com.study.springboot.dto;

//MemberEntity : DB Table/Field와 1:1 매칭되어 변경안됨.
//Save,update 등의 용도로 필드(변수)가 필요한 경우에 DTO를 설계한다.

// html입력폼 -> DTO -> DAO(Entity) -> Repo인터페이스 -> DB

import com.study.springboot.entity.MemberEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberSaveDto {
    private Long id;
    private String userId;
    private String userPw;
    private String userName;
    private String userRole;
    private String userAddress; //입력폼에는 있고, DB에는 없는 필드
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    //Dto -> Entity 변환 함수
    public MemberEntity toSaveEntity(){
        //builder() 패턴을 사용하면 좋은 점.
        //  생성자 함수, Setter함수 사용하는 대신
        //  1. 매개변수의 순서와 갯수를 지켜야 된다.
        //  2. Setter경우 코드가 길어진다.
        return MemberEntity.builder()
                .id(id)
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }
    //Entity -> Dto 업데이트 함수
    public void updateDto(MemberEntity entity) {
        this.setUserId( entity.getUserId() );
        this.setUserPw( entity.getUserPw() );
        this.setUserName( entity.getUserName() );
        this.setUserRole( entity.getUserRole() );
    }
}
