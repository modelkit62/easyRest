package com.example.zero.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
//@WebMvcTest(ZeroController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ZeroControllerTest_2 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testResultadoController() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/zero")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Pound\",\"country\":\"UK\",\"value\":\"22.2\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("La ostia"))
                .andDo(MockMvcResultHandlers.print());
    }

}
