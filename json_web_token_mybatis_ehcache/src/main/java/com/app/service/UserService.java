package com.app.service;

import com.app.model.User;

public interface UserService {

    long save(User user);

    User findUserByUsername(String name);
}
