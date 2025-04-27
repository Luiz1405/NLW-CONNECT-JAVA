package com.nlw.events.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nlw.events.model.Event;
import com.nlw.events.service.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class eventController {

    @Autowired
    private EventService service;

    @PostMapping("/events")
    public Event addNewEvent(@RequestBody Event newEvent) {
        return service.addNewEvent(newEvent);
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }
    
    
}
