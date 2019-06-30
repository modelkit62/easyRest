package com.example.zero.controller;


import com.example.zero.model.Resultado;
import com.example.zero.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ResultadoController {

    @Autowired
    ResultadoService resultadoService;

    @RequestMapping(value = "/resultado", method = GET, produces = APPLICATION_JSON_VALUE)
    public Resultado doIt() {
        return resultadoService.cambiaValor(new Resultado());
    }
}
