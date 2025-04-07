package com.study.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    //필드 주입
    //@Autowired
    //private MemberRepository memberRepository;
    
    @GetMapping("/")
    public String main(Model model){
        System.out.println("memberRepository = " + memberRepository);

//        memberRepository.save( new MemberEntity(Long.valueOf(1),
//                "hong", "1234", "홍길동2", "ROLE_USER",
//                LocalDate.now()) );
        //@GeneratedValue 설정이므로, 수동으로 ID값을 쓰지 말것.
        memberRepository.save( new MemberEntity(null,
                "tom", "5678", "톰아저씨", "ROLE_USER",
                LocalDate.now()) );

        List<MemberEntity> list = memberRepository.findAll();
        System.out.println("list.size() = " + list.size());

        model.addAttribute("list", list);

        return "index"; //index.html로 응답
    }
}
