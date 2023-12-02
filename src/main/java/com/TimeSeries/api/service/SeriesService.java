package com.TimeSeries.api.service;

import com.TimeSeries.api.model.Serie;
import com.TimeSeries.api.repository.SeriesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Data
@Service
public class SeriesService {

    @Autowired
    private SeriesRepository timeSeriesRepository;
    public Iterable<Serie> getSeries() {
        return timeSeriesRepository.findAll();
    }
    public Optional<Serie> getSerieById(long id){
        return timeSeriesRepository.findById(id);
    }
    public void deleteSerieById(Long id) {
        timeSeriesRepository.deleteById(id);
    }
    public void deleteSerie(Serie serie) {
        timeSeriesRepository.delete(serie);
    }
    public void addSerie(String title, String description){
        Serie serie = new Serie();
        serie.setTitle(title);
        serie.setDescription(description);
        timeSeriesRepository.save(serie);
    }
    public Serie updateSerie(Long id, Serie updatedSerie) {
        Optional<Serie> existingSerie = timeSeriesRepository.findById(id);

        if (existingSerie.isPresent()) {
            updatedSerie.setSerieId(id);
            return timeSeriesRepository.save(updatedSerie);
        } else {
             throw new NoSuchElementException("the element doesnot exist ");
        }
    }
}



