package com.asthon.taxi.app.service;

import com.asthon.taxi.app.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
