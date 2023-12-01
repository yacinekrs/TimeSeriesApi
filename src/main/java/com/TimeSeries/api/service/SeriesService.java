package com.TimeSeries.api.service;

import com.TimeSeries.api.model.Serie;
import com.TimeSeries.api.repository.SeriesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class SeriesService {

    @Autowired
    private SeriesRepository timeSeriesRepository;
    public Optional<Serie> getSerie(final long id){
        return timeSeriesRepository.findById(id);
    }

}



