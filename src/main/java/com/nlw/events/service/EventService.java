package com.nlw.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlw.events.model.Event;
import com.nlw.events.repository.EventRespository;

@Service
public class EventService {

    @Autowired
    private EventRespository eventRepo;

    public Event addNewEvent(Event event) {
        event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ", "-"));

        return eventRepo.save(event);
    }

    public List<Event> getAllItens(){
        return (List<Event>)eventRepo.findAll();
    }

    public Event getByPrettyName(String prettyName){
        return eventRepo.findByPrettyName(prettyName);
    }
}
