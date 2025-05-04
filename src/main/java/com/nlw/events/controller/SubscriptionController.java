package com.nlw.events.controller;



import org.apache.catalina.valves.rewrite.ResolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.nlw.events.dto.ErroMessage;
import com.nlw.events.dto.SubscriptionResponse;
import com.nlw.events.exception.EventNotFoundException;
import com.nlw.events.exception.SubscriptionConflictException;
import com.nlw.events.model.Subscription;
import com.nlw.events.model.User;
import com.nlw.events.service.SubscriptionService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionService service;

    @PostMapping("/subscription/{prettyName}")
    public ResponseEntity<?> createSubscription(@PathVariable String prettyName, @RequestBody User subscriber ) {
     try{   
     SubscriptionResponse res = service.createNewSubscription(prettyName, subscriber);
     if (res != null) {
        return ResponseEntity.ok(res);
     }

    } catch(EventNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErroMessage(ex.getMessage()));
    }
    catch(SubscriptionConflictException ex) {
        return ResponseEntity.status(409).body(new ErroMessage(ex.getMessage()));
    }
    return ResponseEntity.badRequest().build();
}
}
