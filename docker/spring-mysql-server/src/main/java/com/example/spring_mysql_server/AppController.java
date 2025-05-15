package com.example.spring_mysql_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    MemberRepo memberRepo;

    @GetMapping("/")
    public String home() {

        List<Member> list = memberRepo.findAll();

        return "데이터 갯수:" + list.size();
    }
}
