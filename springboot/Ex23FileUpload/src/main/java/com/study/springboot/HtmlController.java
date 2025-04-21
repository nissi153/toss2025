package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
        //http://localhost:8080/upload/255a0168-cf20-4e37-bd10-2e1d03be8400_image.png
        return "upload";
    }
    @PostMapping("/upload2")
    public String upload2(@RequestParam MultipartFile[] uploadfile,
                          Model model) throws IOException {
        List<FileDto> list = new ArrayList<>();
        for( MultipartFile file : uploadfile){
            if(!file.isEmpty()){
                //FileDto생성
                FileDto dto = new FileDto(UUID.randomUUID().toString(),
                        file.getOriginalFilename(),
                        file.getContentType());
                list.add( dto );

                //File을 물리적으로 기록하기
                File newFileName = new File(dto.getUuid() + "_" + dto.getFileName());
                file.transferTo( newFileName );

                //DB에 파일이름을 기록한다.

            }
        }
        model.addAttribute("files", list);
        return "result";
    }

}




