package com.example.zero.controller;

import com.example.zero.model.MyCurrency;
import com.example.zero.service.ZeroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ZeroController.class)
public class ZeroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    ZeroController zeroController;

    @MockBean
    ZeroService zeroService;


    private MyCurrency myCurrency = new MyCurrency("Pound","UK", 23.4);

    @Test
    public void testZeroControler() throws Exception {

        when(zeroService.doCurrency(myCurrency)).thenReturn("De puta madre");

        String json = mapper.writeValueAsString(myCurrency);

        mockMvc.perform(get("/zero")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        assertEquals("De puta madre", zeroController.compare(myCurrency));
    }



}
