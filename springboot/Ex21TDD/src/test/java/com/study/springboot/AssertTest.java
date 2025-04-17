package com.study.springboot;

//단정(Assert) 메서드 : 테스트 케이스의 수행 결과를 판별하는 용도로 사용.
//종류
//assertArrayEquals(a, b) : 배열 a와 b가 일치함을 확인한다.
//assertEquals(a, b) : 객체 a와 b가 일치함을 확인한다. (객체에 정의되어 있는 equals를 통해 비교한다.)
//assertSame(a, b) : 객체 a와 b 가 같은 객체임을 확인 한다. (객체 자체를 비교한다. == )
//assertTrue(a) : 조건 a가 참인지를 확인한다.
//assertFalse(a) : 조건 a가 거짓인지를 확인한다.
//assertNotNull(a) : 객체 a가 null인지 확인한다.
//assertAll() : 모든 종류의 assert를 각각 다 실행한다. 중간에 멈추지 않음.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Adder {
    public int add(int x, int y){
        return x + y;
    }
}

public class AssertTest {
    private final Adder adder = new Adder();
    private final Adder adder2 = new Adder();
    private final String[] arr1 = { "a", "b" };
    private final String[] arr2 = { "a", "c" };

    @Test
    void test1(){
        assertArrayEquals( arr1, arr2 );
    }
    @Test
    void test2(){
        assertEquals( 3, adder.add( 1, 2) );
    }
    @Test
    void test3(){
        assertSame(adder, adder);
        assertSame(adder, adder2); //주소값이 다름(서로 다른 객체임)
    }
    @Test
    void test4(){
        // assertTrue( 3 < 10 ); //true이면 통과
        // assertTrue( 3 > 10 );
        assertFalse( 3 > 10 ); //false이면 통과
    }
    @Test
    void test5() {
        assertNotNull( adder ); //null이 아니면 통과
    }
    @Test
    void test6() {
        assertAll(
                //람다식 테스트 코드
                () -> { assertTrue(false, "assertTrue fail.");  },
                () -> {
                    Object obj = new Object();
                    assertNotNull( obj, "obj Not Null");
                }
        );
    }
}
