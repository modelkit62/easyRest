package com.example.zero.controller;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
                        .content(getIncommingRequest())
                        // .content("{\"name\":\"Pound\",\"country\":\"UK\",\"value\":\"22.2\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("La ostia"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testResultadoControllerWithAssertion() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/zero")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getIncommingRequest())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        JSONAssert.assertEquals(contentAsString, "{\"name\":\"La ostia\",\"country\":\"UK\",\"value\":25.5}", JSONCompareMode.LENIENT);

    }

    @Test
    public void failFlow() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/zero")
                .contentType(MediaType.APPLICATION_JSON)
                .content("")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


    // with GUAVA can bring JSON from resources
    private String getIncommingRequest() throws IOException {
        return Resources.toString(Resources.getResource("testRequestJson/incoming-request.json"), Charsets.UTF_8);

    }

    /*private String getExpectedResponseString(){ // EN PROSPECTSCONTROLLERIMPLTEST: getsGatewayIncomingRequest
        Resource<MyCurrency> resource = new Resource<MyCurrency>()
    }*/


}
