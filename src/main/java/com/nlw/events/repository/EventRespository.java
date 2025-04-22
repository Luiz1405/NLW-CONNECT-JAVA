package com.nlw.events.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlw.events.model.Event;

public interface EventRespository extends CrudRepository<Event, Integer> {

}
