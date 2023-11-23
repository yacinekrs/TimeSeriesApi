package com.TimeSeries.api.repository;

import com.TimeSeries.api.model.SeriesInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SeriesRepository extends CrudRepository<SeriesInfo, Long> {

}