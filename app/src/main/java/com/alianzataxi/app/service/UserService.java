package com.alianzataxi.app.service;

import com.alianzataxi.app.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
