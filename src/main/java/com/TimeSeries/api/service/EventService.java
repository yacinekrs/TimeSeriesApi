package com.TimeSeries.api.service;

import com.TimeSeries.api.model.SeriesEvent;
import com.TimeSeries.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Iterable<SeriesEvent> getEvents() {
        return eventRepository.findAll();
    }
    public Optional<SeriesEvent> getEventById(Long id) {
        return eventRepository.findById(id);
    }
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
    public void deleteEvent(SeriesEvent event) {
        eventRepository.delete(event);
    }
}
