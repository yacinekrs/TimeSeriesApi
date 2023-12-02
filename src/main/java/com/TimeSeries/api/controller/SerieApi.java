package com.TimeSeries.api.controller;

import com.TimeSeries.api.model.Serie;
import com.TimeSeries.api.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/series")
public class SerieApi {
    @Autowired
    SeriesService seriesService;

    @GetMapping(value = "{id}", produces = {MediaType.TEXT_HTML_VALUE})
    public String getSerie(@PathVariable long id,  Model model) {
        Optional<Serie> serie = seriesService.getSerieById(id);
        if (serie.isPresent()){
            Serie serieRec = serie.get();
                model.addAttribute("serieid",serieRec.getSerieId());
                model.addAttribute("seriedescription", serieRec.getDescription());
                model.addAttribute("serietitle", serieRec.getTitle());
                model.addAttribute("serieevents", serieRec.getEvent());
                return "getSerie";
        }
        else return String.valueOf(new ResponseEntity<>(serie.get(), HttpStatus.NOT_FOUND));
    }
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Serie> getSerieJson(@PathVariable long id,  Model model) {
        Optional<Serie> serie = seriesService.getSerieById(id);
        if (serie.isPresent()){
            Serie serieRec = serie.get();
            return new ResponseEntity<>(serie.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(serie.get(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addSerie(@RequestBody Serie serie) {
        try {
            seriesService.addSerie(serie.getTitle(), serie.getDescription());
            return new ResponseEntity<>("Serie added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add Serie: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerieById(@PathVariable Long id) {
        seriesService.deleteSerieById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSerie(@RequestBody Serie serie) {
        seriesService.deleteSerie(serie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable long id, @RequestBody Serie updatedSerie) {
        Serie result = seriesService.updateSerie(id, updatedSerie);

        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}