package com.study.springboot;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResDto {
    // { "status": "ok", "message": "로그인 성공" }
    private String status;
    private String message;
}
