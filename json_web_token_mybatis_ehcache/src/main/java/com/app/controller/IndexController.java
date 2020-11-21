package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserRepository;
import com.app.model.User;

@RestController
public class IndexController {
    @Autowired
    private UserRepository repository;

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
	return "hello World!";
    }

    @RequestMapping("/users")
    @ResponseBody
    public String getUsers() {
	StringBuffer sb = new StringBuffer();
	List<User> uesrs = repository.findAll();

	for (User u : uesrs) {
	    sb.append(u.getUsername()).append("\n");
	}
	return sb.toString();
    }

}
