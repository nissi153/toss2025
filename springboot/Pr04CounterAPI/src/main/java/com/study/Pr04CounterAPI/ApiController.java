package com.study.Pr04CounterAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller + @ResponseBody
@RequestMapping("/api/v1")
public class ApiController {
    //서버의 응답은 JSON 문자열로
    //{ count : 1 }
    @GetMapping("/")  //localhost:8080/api/v1/
    public String main(){
        return "Api Server OK.";
    }
}
