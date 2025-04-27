package com.nlw.events.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlw.events.model.User;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
}
