package com.study.springboot.dto;

import com.study.springboot.entity.MemberEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

// spring-boot-starter-validation
// @Valid
//@NotNull // 필드값으로 null을 허용하지 않는다. ""와 " "은 허용한다
//@NotEmpty // 필드값으로 null,""을 허용하지 않는다.  "은 허용한다.
//@NotBlank // 필드값으로 null,""," "을 허용하지 않는다.
//@Positive // 필드값이 양수인지 확인한다. 숫자에만 사용 가능
//@Negative // 필드값이 0이 아닌 음수인지 확인한다.
//@Size(min= , max=) // 필드 값이 Min과 max사이인지 확인할 수 있다.
//@Min(value= )
//@Max(value=)

//@NotNull vs @NonNull vs @Column(nullable=false)

// @NonNull
// @NonNull은 validator의 validation이 아니라 lombok에서 entity에 대한 제약조건 검증 어노테이션이다.
// 값이 null이 들어가면 NullPointException이 일어나며 커스텀 예외로 처리할 수 없다

//Spring framework 5(Spring Boot 2)부터 compile time에 NullPointException을
// 최대한 방지하기 위한 annotation이 지원되고 있습니다.
// @NonNull : 변수나 return value에 null을 허용하지 않을 경우 사용합니다.
//         org.springframework.lang의 @NonNull을 사용해야 합니다.
// @Nullable : 변수나 return value에 null을 허용하는 경우 사용합니다.
//         @NonNull과 마찬가지로 org.springframework.lang에 해당하는 annotation을 사용합니다.

//@Column(nullable=false)는 db에 들어갈 때 null이면 hibernate쪽에서 오류를 발생시키는것.

@Getter
@Setter
@Builder
public class MemberJoinDto {

    @Nullable
    private Long id;

    @Size(min=1,max=10,message = "user_id가 10자를 넘을 수 없습니다.")
    @NotBlank(message = "user_id에 null, 빈문자열, 스페이스문자열만을 넣을 수 없습니다.")
    private String username;

    @NotBlank(message = "user_pw에 null, 빈문자열, 스페이스문자열만을 넣을 수 없습니다.")
    private String password;

    private String user_name;

    @NotBlank(message = "user_role에 null, 빈문자열, 스페이스문자열만을 넣을 수 없습니다.")
    private String user_role;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate join_date;

    public MemberEntity toSaveEntity() {
        return MemberEntity.builder()
                .username(username)
                .password(password)
                .user_name(user_name)
                .user_role(user_role)
                .join_date(join_date)
                .build();
    }
    public MemberEntity toUpdateEntity() {
        return MemberEntity.builder()
                .id(id)
                .username(username)
                .password(password)
                .user_name(user_name)
                .user_role(user_role)
                .join_date(join_date)
                .build();
    }

}
