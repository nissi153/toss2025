package com.study.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {
    @Autowired
    private Member member;

    @Test
    void getUsername() {
        // given (application.properties에 정의된 값 기준)
        String expectedUsername = "testUser";
        String expectedPassword = "1234";

        // then
        assertEquals(expectedUsername, member.getUsername());
        assertEquals(expectedPassword, member.getPassword());
    }
}