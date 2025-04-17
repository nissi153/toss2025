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
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.entry;
import static org.assertj.core.api.Assertions.offset;

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
    @Test
    @DisplayName("list 테스트")
    void test2(){
        //given
        //when
        List<String> list = Arrays.asList("1", "2", "3");
        //then
        Assertions.assertThat(list).contains("1");
        Assertions.assertThat(list).isNotEmpty();
        Assertions.assertThat(list).startsWith("1");
        Assertions.assertThat(list)
                .isNotEmpty()
                .contains("1")
                .doesNotContainNull()
                .containsSequence("2", "3"); //"2" 다음은 "3" 인가?
    }
    @Test
    @DisplayName("객체 비교 테스트")
    void test3(){
        //given when
        User user1 = new User("hong", "도둑", "test@mail.com");
        User user2 = new User("hong", "도둑2", "test@mail.com");
        //then
        //객체 주소 비교(얇은 비교)
        Assertions.assertThat(user1).isEqualTo(user2);
        //객체 내용 비교(깊은 비교)
        Assertions.assertThat(user1).usingRecursiveComparison().isEqualTo(user2);
    }
    @Test
    @DisplayName("맵 테스트")
    void test4(){
        //given when
        Map<String, String> map = new HashMap<>();
        map.put("name", "hong");
        //then
        Assertions.assertThat(map)
                .isNotEmpty()
                .containsKeys("name")
                .doesNotContainKeys("age")
                .contains(entry("name", "hong"));
    }
    @Test
    @DisplayName("예외테스트")
    void test5(){
        //given
        String input = "abc";
        //input.charAt( 3 );
        //when then
        //"java.lang.StringIndexOutOfBoundsException: String index out of range: 3"
        Assertions.assertThatThrownBy( ()->{ input.charAt( 3 ); } )
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf( 3 ));
    }
    @Test
    @DisplayName("문자열 테스트")
    void test6(){
        //given when
        String msg = "Hello, world! Nice to meet you.";
        //then
        Assertions.assertThat(msg)
                .isNotEmpty()
                .contains("Nice")
                .contains("world")
                .doesNotContain("zzz")
                .startsWith("Hello")
                .endsWith("u.")
                .isEqualTo("Hello, world! Nice to meet you.");
    }
    @Test
    @DisplayName("숫자 테스트")
    void test7(){
        //given when then
        Assertions.assertThat(3.14d)
                .isPositive()
                .isGreaterThan(3)
                .isLessThan(4)
                .isEqualTo(3, offset(1d)) //일의 자릿수까지 비교
                .isEqualTo(3.1, offset(0.1d)) //소숫점 첫째자리까지 비교
                .isEqualTo(3.14);
    }
    @Test
    @DisplayName("SoftAssertions 사용하기")
    void test8(){
        //given when
        User user = new User("hong", "thief", "bank@mail.com");
        //then
        //SoftAssertions : 동시에 여러 테스트를 진행하고, 중간에 에러가 나도
        //  모든 검사를 수행한 후에 결과를 보여줌.
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(user).isNotNull();
        soft.assertThat(user.getName()).isEqualTo("hong");
        soft.assertThat(user.getNickname()).isEqualTo("");
        soft.assertThat(user.getEmail()).isEqualTo("bank@mail.com");
        soft.assertAll();
    }
}
