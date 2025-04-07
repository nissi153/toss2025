package com.study.springboot;

//데이타 모델링 클래스(데이타를 담고 있는)의 종류
//1. DTO 클래스 : Data Transfer Object, 데이타가 자주 바뀜. 로직(코드) 포함 안됨.
//             : 다른 계층간에 데이타 전송시 사용.
//2. VO 클래스 : View Object, 데이타가 안바뀜. 로직이 포함됨.
//            : 바뀌지 않는 데이타 보관시 사용.
//3. Entity 클래스 : DB 테이블 1:1 매칭, 로직(코드) 포함 안됨. JPA에서 사용.

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//@Entity : DB테이블과 1:1로 매칭되는 JPA 클래스에 사용함.
//@Table : 클래스이름이 테이블이름으로 기본 설정되는데("memberEntity")
//         테이블이름을 바꿔주는데 사용
@Entity
@Table(name="member")
@Getter
//@Setter : 비추천 - 실제 DB에 중복 적용되는 경우 발생.
public class MemberEntity {

}



