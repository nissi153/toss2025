package com.study.Pr05CalcAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //@Controller + @ResponseBody
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    private ResDto resDto;

    @PostMapping("/calc-submit")
    public @ResponseBody ResDto calcSubmit(@RequestBody ReqDto dto) {
        System.out.println(dto.getNum1());
        System.out.println(dto.getNum2());
        System.out.println(dto.getCalType());

        resDto.setStatus("ok");
        if( dto.getCalType().equals("add") ){
            resDto.setResult( dto.getNum1().intValue() + dto.getNum2().intValue() );
        }
        if( dto.getCalType().equals("sub") ){
            resDto.setResult( dto.getNum1().intValue() - dto.getNum2().intValue() );
        }
        if( dto.getCalType().equals("mul") ){
            resDto.setResult( dto.getNum1().intValue() * dto.getNum2().intValue() );
        }
        if( dto.getCalType().equals("div") ){
            resDto.setResult( dto.getNum1().intValue() / dto.getNum2().intValue() );
        }

        return resDto;
    }
}
