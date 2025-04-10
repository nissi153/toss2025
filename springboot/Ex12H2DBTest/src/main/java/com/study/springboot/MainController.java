package com.study.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    //생성자 주입
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String main(Model model){
        memberRepository.save(
                new MemberEntity(null, "hong", "1234", "홍길동", "ROLE_USER",
                        LocalDate.parse("2025-04-10")));
        memberRepository.save(
                new MemberEntity(null, "hong", "1234", "변사또", "ROLE_USER",
                        LocalDate.parse("2025-04-10")));
        memberRepository.save(
                new MemberEntity(null, "hong", "1234", "강감찬", "ROLE_USER",
                        LocalDate.parse("2025-04-10")));

        List<MemberEntity> list = memberRepository.findAll(); //Select * from member;
        model.addAttribute("list", list);
        return "index";
    }
}
