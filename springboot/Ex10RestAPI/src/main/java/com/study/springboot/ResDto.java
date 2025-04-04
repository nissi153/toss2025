package com.study.springboot;

import lombok.Data;

@Data
public class ResDto {
   //{ status: "ok", message: "로그인되었습니다." }
    private String status;
    private String message;
}
