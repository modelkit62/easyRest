package com.example.zero.controller;


import com.example.zero.model.MyCurrency;
import com.example.zero.service.ZeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zero")
public class ZeroController {

    ZeroService service;

    @Autowired
    public ZeroController(ZeroService service) {
        this.service = service;
    }

    @GetMapping
    public MyCurrency compare(@RequestBody MyCurrency myCurrency){

        if(myCurrency.getCountry() == null){
            myCurrency.setName("Los Cojones!");
            myCurrency.setCountry("Los Cojones!");
            myCurrency.setValue(25.3);
        }

        return service.doCurrency(myCurrency);
    }

}
