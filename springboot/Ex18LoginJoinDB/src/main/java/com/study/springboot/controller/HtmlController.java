package com.study.springboot.controller;

import com.study.springboot.dto.MemberLoginDto;
import com.study.springboot.entity.MemberEntity;
import com.study.springboot.entity.MemberRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HtmlController {
    final MemberRepository memberRepository;

    @GetMapping("/")
    public String main(){
        return "index";
    }
    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }
    @PostMapping("/loginAction")
    @ResponseBody
    public String loginAction(@Valid @ModelAttribute MemberLoginDto dto,
                              BindingResult bindingResult,
                              HttpSession session){
        if(bindingResult.hasErrors()){
            //바인딩 오류 발생
            //DTO에 설정한 message값을 가져온다.
            String detail = bindingResult.getFieldError().getDefaultMessage();
            System.out.println("detail = " + detail);
            //DTO에 유효성체크를 걸어놓은 어노테이션명을 가져온다.
            String bindResultCode = bindingResult.getFieldError().getCode();
            System.out.println("bindResultCode = " + bindResultCode);
            return "<script>alert('"+ detail +"'); history.back();</script>";
        }
        System.out.println("dto = " + dto.getUserId());
        System.out.println("dto = " + dto.getUserPw());

        //1.아이디/암호의 유효성(Size, null, Blank)
        //2.아이디가 없을때 -> 회원가입 필요
        //2.암호가 틀릴때 -> 암호재입력

        //로그인 처리 로직
        //1. 메시지 : "아이디가 없습니다."
        //2.        : "암호가 틀립니다."
        Optional<MemberEntity> optional =
                memberRepository.findByUserId(dto.getUserId());
        if( !optional.isPresent() ) {
            return "<script>alert('아이디가 없습니다.'); history.back();</script>";
        }
        Optional<MemberEntity> optional2 =
                memberRepository.findByUserPw(dto.getUserPw());
        if( !optional2.isPresent() ) {
            return "<script>alert('암호가 맞지 않습니다.'); history.back();</script>";
        }
        //로그인 성공 - 세션에 로그인 여부/로그인 아이디/로그인 권한 저장
        session.setAttribute("isLogin", true);
        session.setAttribute("userId", dto.getUserId());
        session.setAttribute("userRole", optional2.get().getUserRole());

        return "<script>alert('로그인 성공'); location.href='/';</script>";
    }

    @GetMapping("/logoutAction")
    public String logoutAction(HttpSession session){
        session.invalidate();
        return "index";
    }

}
