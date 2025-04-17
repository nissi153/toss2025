package com.study.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
class ApiControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean //ApiController에서 주입받은 Bean객체에 대해서 Mock형태로 객체 생성.
    MemberService memberService;

    @Autowired
    WebApplicationContext ctx;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }
    @Test
    void loginAction() throws Exception {
        //given when
        // loginAction함수가 제대로 동작하는 조건을 기술한다.
        given(memberService.loginAction(new MemberDto("hong", "1234")))
                .willReturn(1);
        //then
        //기대하는 응답 DTO 객체 생성
        ResDto resDto = ResDto.builder()
                .status("ok")
                .message("로그인성공")
                .build();
        MemberDto dto = MemberDto.builder()
                .loginId("hong")
                .loginPw("1234")
                .build();

        Gson gson = new Gson();
        String jsonString = gson.toJson( dto );
        //Jackson 라이브러리가 Springboot의 공식 라이브러리이다.
        //@ModelAttribute, @RequestBody, @ResponseBody
        //*기본생성자가 없으면 오류!
        //com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of ...
        String jsonString2 = new ObjectMapper().writeValueAsString( dto );

        mockMvc.perform(post("/api/v1/loginAction")
                         .content( gson.toJson( dto ) )//JSON문자열을 Body에 실어서 보낸다.
                         .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.message").exists())
                .andExpect(status().isOk())
                .andDo(print());

        //verity : 해당 객체의 메소드가 실행되었는지를 체크해 줌.
        verify(memberService).loginAction(new MemberDto("hong","1234"));

    }
}