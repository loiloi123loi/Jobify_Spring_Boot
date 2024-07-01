package com.learn.Spring_Learn.service;

import com.learn.Spring_Learn.models.User;

public interface AuthenticationService {
    String registerUser(User user, String repeat_password);
}
