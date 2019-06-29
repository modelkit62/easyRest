package com.example.zero.service;

import com.example.zero.model.MyCurrency;
import org.springframework.stereotype.Service;

@Service
public class ZeroService {
    public String doCurrency(MyCurrency myCurrency) {

        if (myCurrency.getValue() > 9){
            return "Mayor a 9";
        }
        return "Mayor a 9";

    }
}
