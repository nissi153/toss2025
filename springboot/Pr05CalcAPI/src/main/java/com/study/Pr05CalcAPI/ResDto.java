package com.study.Pr05CalcAPI;

import lombok.Data;
import org.springframework.stereotype.Component;

// "{ 'status': ok, 'result': 10 }"
@Component
@Data
public class ResDto {
    private String status;
    private Integer result;
}
