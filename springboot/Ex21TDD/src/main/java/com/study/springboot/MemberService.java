package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// Controller -> Service -> Repository

@Slf4j
@Service //비즈니스 로직을 수행하는 클래스로 정의. 회원관리 로직 처리.
public class MemberService {
    public int loginAction(MemberDto memberDto) {

        if( memberDto.getLoginId().equals("hong") &&
            memberDto.getLoginPw().equals("1234") ) {
            return 1; //로그인 성공
        }else{
            return 0; //로그인 실패
        }
    }
}
