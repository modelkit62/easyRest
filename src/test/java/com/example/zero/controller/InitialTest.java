package com.example.zero.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitialTest {

    @Autowired
    private ZeroController zeroController;

    @Autowired
    private SimpleController simpleController;

    @Test
    public void contexLoads_1() throws Exception {
        assertThat(zeroController).isNotNull();
    }

    @Test
    public void contexLoads_2() throws Exception {
        assertThat(simpleController).isNotNull();
    }
}
