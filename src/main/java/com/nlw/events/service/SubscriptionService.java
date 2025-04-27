package com.nlw.events.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlw.events.model.User;
import com.nlw.events.repository.EventRespository;
import com.nlw.events.repository.SubscriptionRepository;
import com.nlw.events.repository.UserRepository;
import com.nlw.events.model.Event;
import com.nlw.events.model.Subscription;

@Service
public class SubscriptionService {

    @Autowired
    private EventRespository eventRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SubscriptionRepository subRepository;

    public Subscription createNewSubscription(String eventName, User user) {
        Subscription subs = new Subscription();
        Event evt = eventRepo.findByPrettyName(eventName);
        user = userRepo.save(user);
        subs.setEvent(evt);
        subs.setSubscriber(user);

        Subscription res = subRepository.save(subs);

        return res;

    }
}
