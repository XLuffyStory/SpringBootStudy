package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.model.User;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository personRepository;

    public long save(User person) {
        return personRepository.save(person);
    }

    public User findUserByUsername(String name){
        return personRepository.findByUsername(name);
    }

}
