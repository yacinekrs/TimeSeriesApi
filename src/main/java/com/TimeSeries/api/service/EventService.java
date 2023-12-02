package com.TimeSeries.api.service;

import com.TimeSeries.api.model.Event;
import com.TimeSeries.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }
    public Optional<Event> getEventById(long id) {
        return eventRepository.findById(id);
    }
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }
    public void addEvent(Date date, int value,long id_serie){
        Event event = new Event();
        event.setDate(date);
        event.setValue(value);
        event.setId_serie(id_serie);
        eventRepository.save(event);
    }
    public Event updateEvent(Long id, Event updatedEvent) {
        Optional<Event> existingEvent = eventRepository.findById(id);

        if (existingEvent.isPresent()) {
            updatedEvent.setEventId(id);
            return eventRepository.save(updatedEvent);
        } else {
            throw new NoSuchElementException("the element does not exist ");
        }
    }
}
