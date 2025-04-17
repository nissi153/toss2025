package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    MemberService memberService;

    //로그인 액션(아이디,암호)
    //1. DB에서 동일한 아이디와 암호를 가진 행(레코드)이 있는가?
    //2. 있으면, 로그인 성공
    //3. 없으면, 로그인 실패
    @PostMapping("/loginAction")
    public ResDto loginAction(@RequestBody ReqDto reqDto) {

        MemberDto memberDto = MemberDto.builder()
                        .loginId(reqDto.getLoginId())
                        .loginPw(reqDto.getLoginPw())
                        .build();

        int result = memberService.loginAction( memberDto );

        ResDto resDto = null;
        if( result == 1 ) {
            //로그인성공
            resDto = ResDto.builder()
                    .status("ok")
                    .message("로그인성공")
                    .build();
        }else{
            //로그인실패
            resDto = ResDto.builder()
                    .status("ok")
                    .message("로그인실패")
                    .build();
        }
        return resDto;
    }
}
