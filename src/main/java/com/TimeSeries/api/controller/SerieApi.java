package com.TimeSeries.api.controller;

import com.TimeSeries.api.model.Serie;
import com.TimeSeries.api.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class SerieApi {
    @Autowired
    SeriesService seriesService;

    @GetMapping(path = "series")
    public String testSerie() {
        Optional<Serie> serie = seriesService.getSerieById(1);
        System.out.println(serie.get());
        if (serie.get() != null) {
            Serie serie2 = serie.get();
            return serie2.toString();
        }
        return "1";
    }

    @PostMapping(path = "series")
    public ResponseEntity<String> addSerie(@RequestBody Serie serie) {
        try {
            seriesService.addSerie(serie.getTitle(), serie.getDescription());
            return new ResponseEntity<>("Serie added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add Serie: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
