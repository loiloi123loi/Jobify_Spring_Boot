package com.learn.Spring_Learn.exception;

import lombok.Getter;

@Getter
public class PasswordException extends RuntimeException {
    private final String passwordError;

    public PasswordException(String passwordError) {
        this.passwordError = passwordError;
    }
}
