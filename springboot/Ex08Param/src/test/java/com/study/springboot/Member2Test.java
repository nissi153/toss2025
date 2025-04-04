package com.study.springboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Member2Test {

    @Test
    void getUsername() {
        //given
        String username = "testUser";
        String password = "1234";

        //when
        Member2 member2 = new Member2(username, password);

        //then
        assertEquals("testUser123", member2.getUsername());
        assertEquals("1234", member2.getPassword());
    }

    @Test
    void getPassword() {
    }
}