package com.snwolf.service.impl;

import com.snwolf.model.User;
import com.snwolf.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(User user) {
        log.info("username: " + user.getName());
        return user;
    }
}
