package com.learn.Spring_Learn.service;

import com.learn.Spring_Learn.models.User;

import java.util.Map;

public interface AuthenticationService {
    Map<String, Object> registerUser(User user, String repeat_password);
}
