package com.TimeSeries.api.repository;

import com.TimeSeries.api.model.SeriesEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<SeriesEvent, Long> {

}