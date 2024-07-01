package com.learn.Spring_Learn.controllers;

import com.learn.Spring_Learn.dto.auth.register.RegisterRequest;
import com.learn.Spring_Learn.mapper.AuthenticationMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.learn.Spring_Learn.constants.PathConstants.API_V1_AUTH;
import static com.learn.Spring_Learn.constants.PathConstants.REGISTER;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_AUTH)
public class AuthenticationController {
    private final AuthenticationMapper authenticationMapper;

    @PostMapping(REGISTER)
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(authenticationMapper.registerUser(request, bindingResult));
    }
}
