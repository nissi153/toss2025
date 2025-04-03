package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "index";  //index.html 파일을 렌더해서 내려줌.
    }
    @GetMapping("/index1")
    public String index1(Model model) {
        //Model 클래스 : 스프링에서 데이터를 담아서 전달하는 용도의 클래스 객체
        model.addAttribute("name_text", "<ins>홍길동</ins>");
        model.addAttribute("name_html", "<ins>홍길동</ins>");
        model.addAttribute("server_value", "HONG");
        return "index";
    }

    @GetMapping("index2")
    public String index2(Model model){
        model.addAttribute("address", "서울");
        model.addAttribute("address_null", null);
        model.addAttribute("address_empty", "");
        return "index2";
    }

    @GetMapping("/index3")
    public String index3(Model model){
        model.addAttribute("standardDate", new Date());
        model.addAttribute("localDate", LocalDate.now() );
        model.addAttribute("localDateTime", LocalDateTime.now() );

        model.addAttribute( "number1", 12345678 );
        model.addAttribute( "number2", 123456.789 );

        return "index3"; //index3.html로 응답함.
    }
    @GetMapping("/index4")
    public String index4(Model model){
        model.addAttribute("role", "guest");

        return "index4"; //index4.html로 응답함.
    }
    @GetMapping("/index5")
    public String index5(Model model){
        Member member = new Member("hong", "1234");
        model.addAttribute("member", member);

        List<Member> list = new ArrayList<Member>();
        list.add( new Member("lee", "2222") );
        list.add( new Member("hana", "3333") );
        list.add( new Member("tom", "4444") );
        model.addAttribute("list", list);

        return "index5"; //index5.html로 응답함.
    }
    @GetMapping("/index6")
    public String index6() {
        return "index6"; //index6.html로 응답함.
    }
    @GetMapping("/index7")
    public String index7() {
        return "index7"; //index7.html로 응답함.
    }

}
