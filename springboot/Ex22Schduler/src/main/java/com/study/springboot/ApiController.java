package com.study.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/api/batch-job")
    public String batchJob(){
        //실제작업
        return "batch-job started!";
    }
}
