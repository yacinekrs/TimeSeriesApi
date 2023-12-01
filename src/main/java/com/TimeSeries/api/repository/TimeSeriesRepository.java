package com.TimeSeries.api.repository;

import com.TimeSeries.api.model.Serie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TimeSeriesRepository extends CrudRepository<Serie,Long> {

}