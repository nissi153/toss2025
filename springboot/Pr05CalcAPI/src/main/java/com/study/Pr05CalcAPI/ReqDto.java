package com.study.Pr05CalcAPI;

import lombok.Data;
import org.springframework.stereotype.Component;

//{ num1: 2, num2: 3, calType: inputCalType };
@Component
@Data
public class ReqDto {
    private Integer num1;
    private Integer num2;
    private String calType; //"add"
}
