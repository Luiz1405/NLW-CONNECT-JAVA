package com.nlw.events.controller;

import org.apache.catalina.valves.rewrite.ResolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.nlw.events.dto.ErroMessage;
import com.nlw.events.dto.SubscriptionResponse;
import com.nlw.events.exception.EventNotFoundException;
import com.nlw.events.exception.SubscriptionConflictException;
import com.nlw.events.exception.UserIndicatorNotFoundException;
import com.nlw.events.model.Subscription;
import com.nlw.events.model.User;
import com.nlw.events.service.SubscriptionService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionService service;

    @PostMapping({"/subscription/{prettyName}", "/subscription/{prettyName}/{userId}"})
    public ResponseEntity<?> createSubscription(@PathVariable String prettyName, @RequestBody User subscriber, @PathVariable(required = false) Integer userId ) {
     try {   
     SubscriptionResponse res = service.createNewSubscription(prettyName, subscriber, userId);
     if (res != null) {
        return ResponseEntity.ok(res);
     }

    } catch(EventNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErroMessage(ex.getMessage()));
    }
    catch(SubscriptionConflictException ex) {
        return ResponseEntity.status(409).body(new ErroMessage(ex.getMessage()));
    }
    catch(UserIndicatorNotFoundException ex) {
        return ResponseEntity.status(409).body(new ErroMessage(ex.getMessage()));
    }
    return ResponseEntity.badRequest().build();
}
    @GetMapping("/subscription/{prettyName}/ranking")
    public ResponseEntity<?> generateRankingByEvent(@PathVariable String prettyName){
        try{
            return ResponseEntity.ok(service.getCompleteRanking(prettyName).subList(0, 3));
        } catch(EventNotFoundException e) {
            return ResponseEntity.status(404).body(new ErroMessage(e.getMessage()));
        }
    }

    @GetMapping("/subscription/{prettyName}/ranking/{userId}")
    public ResponseEntity<?> generateRankingByEventAndUserId (@PathVariable String prettyName, @PathVariable Integer userId) {

        try{
           return ResponseEntity.ok(service.getRankingByUser(prettyName, userId));
        }catch(Exception e){
            return ResponseEntity.status(404).body(new ErroMessage(e.getMessage()));
        }
    }
    
    
}
