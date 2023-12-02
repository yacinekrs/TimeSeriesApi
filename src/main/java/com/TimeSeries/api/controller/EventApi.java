package com.TimeSeries.api.controller;

import com.TimeSeries.api.model.Event;
import com.TimeSeries.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/events")
public class EventApi {
    @Autowired
    EventService eventService;

    @GetMapping("{id}")
    public ResponseEntity<Event> testEvent(@PathVariable long id) {
        Optional<Event> event = eventService.getEventById(id);
        if (event.isPresent()) return new ResponseEntity<>(event.get(),HttpStatus.OK);
        else return new ResponseEntity<>(event.get(),HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> addEvent(@RequestBody Event event) {
        try {
            eventService.addEvent(event.getDate(), event.getValue(),event.getId_serie() );
            return new ResponseEntity<>("Event added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add Event: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerieById(@PathVariable Long id) {
        eventService.deleteEventById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEvent(@RequestBody Event event) {
        eventService.deleteEvent(event);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id, @RequestBody Event updatedEvent) {
        Event result = eventService.updateEvent(id, updatedEvent);

        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}