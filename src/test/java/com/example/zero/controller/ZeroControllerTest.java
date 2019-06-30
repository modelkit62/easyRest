package com.example.zero.controller;

import com.example.zero.model.MyCurrency;
import com.example.zero.service.ZeroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
//@WebMvcTest(ZeroController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ZeroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    ZeroService zeroService;


    private MyCurrency myCurrency = new MyCurrency("La ostia", "UK", 23.4);
    //  private MyCurrency myCurrencyBack = new MyCurrency("Pound","UK", 23.4);

    @Test
    public void testZeroControler() throws Exception {

        String json = mapper.writeValueAsString(myCurrency);

        when(zeroService.doCurrency(myCurrency)).thenReturn(myCurrency);

        mockMvc.perform(get("/zero")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

       /* MvcResult mvcResult = mockMvc.perform(get("/zero")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        System.out.println(contentAsString);

        assertTrue(contentAsString);*/


        //assertEquals("De puta madre", zeroController.compare(myCurrency));


        /*this.mockMvc.perform(get("/zero")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("La ostia")));*/

    }


}
