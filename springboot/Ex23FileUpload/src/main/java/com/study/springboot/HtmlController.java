package com.study.springboot;

import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(){
        return "upload";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile[] uploadfile,
                         Model model) throws IOException {
        for( MultipartFile file : uploadfile ) {
            if( !file.isEmpty() ){
                //새로운 파일이름으로 file을 기록한다.
                String uuid = UUID.randomUUID().toString(); //16진수 랜덤한 문자열 생성
                log.info( "uuid : {}", uuid);
                // 1828zx72bz_image.png
                File newFileName = new File( uuid + "_" + file.getOriginalFilename() );
                //물리적으로 파일에 기록한다.
                file.transferTo( newFileName );
            }
        }
        return "upload";
    }
}
