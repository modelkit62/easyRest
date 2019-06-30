package com.example.zero.service;

import com.example.zero.model.Resultado;
import org.springframework.stereotype.Service;

@Service
public class ResultadoService {

    public Resultado cambiaValor(Resultado resultado){
        resultado.setVersion("0.1");
        return resultado;
    }

}
