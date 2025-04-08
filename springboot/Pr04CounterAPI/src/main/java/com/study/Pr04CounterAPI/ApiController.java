package com.study.Pr04CounterAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //@Controller + @ResponseBody
@RequestMapping("/api/v1")
public class ApiController {
    //서버의 응답은 JSON 문자열로
    //{ count : 1 }
    @GetMapping("/")  //localhost:8080/api/v1/
    public String main(){
        return "Api Server OK";
    }

    @Autowired
    private Counter counter;

    @GetMapping("/plus")
    public @ResponseBody Counter plus(){
        counter.setCount(counter.getCount() + 1 );
        return counter;
        // "{ count : 1 }"
    }
    @GetMapping("/minus")
    public @ResponseBody Counter minus(){
        counter.setCount(counter.getCount() - 1);
        return counter;
    }

}
