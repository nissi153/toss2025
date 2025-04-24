package com.study.springboot.controller;

import com.study.springboot.dto.MemberJoinDto;
import com.study.springboot.entity.MemberEntity;
import com.study.springboot.entity.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    final private PasswordEncoder passwordEncoder;
    final private MemberRepository memberRepository;

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }
    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }
    @PostMapping("/joinAction")
    @ResponseBody
    public String joinAction(@Valid @ModelAttribute MemberJoinDto dto,
                             BindingResult bindingResult){
        //입력정보 유효성 체크
        if( bindingResult.hasErrors() ){
            String detail = bindingResult.getFieldError().getDefaultMessage();
            String bindResultCode = bindingResult.getFieldError().getCode();
            System.out.println("detail = " + detail);
            System.out.println("bindResultCode = " + bindResultCode);
            return "<script>alert('" +  detail +"'); histroy.back();</script>";
        }
        //회원가입 절차를 수행한다.
        //비번을 암호화한다.
        String encodePassword = passwordEncoder.encode( dto.getPassword() );
        System.out.println("encodePassword = " + encodePassword);
        dto.setPassword( encodePassword );
        //DB에 저장한다.
        try {
            MemberEntity entity = dto.toSaveEntity();
            memberRepository.save( entity );
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("singupFailed", "이미 등록된 사용자입니다.");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return "<script>alert('회원가입 실패했습니다.'); history.back();</script>";
        }
        //HTTP 응답 코드 : 200 성공
        HttpStatus status = HttpStatus.OK;
        if( status == HttpStatus.OK ) {
            return "<script>alert('회원가입 성공했습니다.'); location.href='/loginForm';</script>";
        }else{
            return "<script>alert('회원가입 실패했습니다.'); history.back();</script>";
        }
    }
}






