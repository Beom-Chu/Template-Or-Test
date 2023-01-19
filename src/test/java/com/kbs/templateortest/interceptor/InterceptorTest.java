package com.kbs.templateortest.interceptor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InterceptorController.class)
public class InterceptorTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("WebMvcTest 테스트")
    public void test() throws Exception {

        mvc.perform(get("/interceptor/test"))
                .andExpect(status().isOk())  //mvc.perform 결과 검증, HTTP Header Status 검증
//                .andExpect(content().string("인터셉트 포함 path 패턴?")); //리턴 값 맞는지 검증
                .andExpect(content().string("인터셉트 포함 path 패턴")); //리턴 값 맞는지 검증

    }
}
