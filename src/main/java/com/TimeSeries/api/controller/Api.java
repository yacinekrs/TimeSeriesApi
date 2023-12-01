package com.TimeSeries.api.controller;

import com.TimeSeries.api.model.Serie;
import com.TimeSeries.api.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class Api {
    @Autowired
    SeriesService service;
    @GetMapping(path = "serie")

    public String hello() {
        Optional<Serie> serie = service.getSerie(2);
        System.out.println(serie.get());
        if(serie.get()!=null){
            Serie serie2 = serie.get();
            return serie2.toString();
        }
        return "1" ;
    }
    @PostMapping(path = "serie")
    public void addSerie()
    {

    }
}
