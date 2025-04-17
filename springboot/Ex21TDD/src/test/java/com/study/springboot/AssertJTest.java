package com.study.springboot;

//AssertJ : JUnit5의 Assert함수와 비슷한 라이브러리
//        : assertThat로 시작하는 함수
// 장점
// 1. 메소드 체이닝을 지원하기 때문에 좀 더 깔끔하고 읽기 쉬운 테스트 코드를 작성할 수 있습니다.
// 2. 개발자가 테스트를 하면서 필요하다고 상상할 수 있는 거의 모든 메소드를 제공합니다.
// 디펜던시
// testCompile 'org.assertj:assertj-core:3.26.3'

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

@Getter
@Setter
@AllArgsConstructor
class User {
    private String name;
    private String nickname;
    private String email;
}
public class AssertJTest {
    @Test
    @DisplayName("isTrue 테스트")
    void test1(){
        //BDD : 행동주도개발
        //given(초기값), when(조건), then(기대되는 결과값)

        //given
        //when
        User user = new User("hong", "", "gildong@mail.com");
        //then
        Assertions.assertThat("".isEmpty()).isTrue();
        Assertions.assertThat(user.getName().isEmpty()).isFalse();
        Assertions.assertThat(user.getNickname().isEmpty()).isTrue();
    }
}
