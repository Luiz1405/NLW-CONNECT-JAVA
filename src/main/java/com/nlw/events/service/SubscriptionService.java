package com.nlw.events.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlw.events.model.User;
import com.nlw.events.repository.EventRespository;
import com.nlw.events.repository.SubscriptionRepository;
import com.nlw.events.repository.UserRepository;
import com.nlw.events.dto.SubscriptionResponse;
import com.nlw.events.exception.EventNotFoundException;
import com.nlw.events.exception.SubscriptionConflictException;
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

    public SubscriptionResponse createNewSubscription(String eventName, User user) {
        Event evt = eventRepo.findByPrettyName(eventName);
        if(evt == null) {
            throw new EventNotFoundException("Evento" + eventName + " não existe");
        }
        User userRec = userRepo.findByEmail(user.getEmail());
        if(userRec == null) {
            userRec = userRepo.save(user);
        }

        Subscription subs = new Subscription();
        subs.setEvent(evt);
        subs.setSubscriber(userRec);

        Subscription tmpSub = subRepository.findByEventAndSubscriber(evt, userRec);
        if(tmpSub != null ) {
            throw new SubscriptionConflictException("Já existe inscrição para o usuário " + userRec.getName() + " no evento " + evt.getTitle());
        }

        Subscription res = subRepository.save(subs);

        return new SubscriptionResponse(res.getSubscriptionNumber(), "http://codecraft.com/" + res.getEvent().getPrettyName()+ "/" + res.getSubscriber().getId());

    }
}
