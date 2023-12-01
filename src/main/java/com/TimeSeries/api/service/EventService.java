package com.TimeSeries.api.service;

import com.TimeSeries.api.model.Event;
import com.TimeSeries.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }
}
