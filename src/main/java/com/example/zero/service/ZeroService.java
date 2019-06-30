package com.example.zero.service;

import com.example.zero.model.MyCurrency;
import org.springframework.stereotype.Service;

@Service
public class ZeroService {
    public MyCurrency doCurrency(MyCurrency myCurrency) {

        if (myCurrency.getValue() > 9){
            myCurrency.setName("La ostia");
        }
        return myCurrency;

    }
}
