package com.example.zero.service;

import com.example.zero.model.MyCurrency;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZeroServiceTest {

    ZeroService zeroService = new ZeroService();

    @Test
    public void testMyService(){

        MyCurrency myCurrency = new MyCurrency("Pound", "UK", 9.7);

        assertEquals("Mayor a 9", zeroService.doCurrency(myCurrency));

    }
}
