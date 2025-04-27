package com.nlw.events.repository;


import org.springframework.data.repository.CrudRepository;

import com.nlw.events.model.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

}
