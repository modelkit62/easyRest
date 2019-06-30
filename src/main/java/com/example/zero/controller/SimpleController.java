package com.example.zero.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @RequestMapping("/")
    public String greeting() {
        return "Hello caracola!";
    }

}
