package com.TimeSeries.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class Api {

    @GetMapping(path = "serie")
    public String hello() {
        return " hello world ";
    }
    @PostMapping(path = "serie")
    public void addSerie()
    {

    }
}
