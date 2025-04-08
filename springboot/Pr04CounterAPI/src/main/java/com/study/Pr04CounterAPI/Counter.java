package com.study.Pr04CounterAPI;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Counter {
    //{ count : 1 }
    private int count = 0;
}
