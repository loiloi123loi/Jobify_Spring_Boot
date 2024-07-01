package com.learn.Spring_Learn.mapper;

import com.learn.Spring_Learn.dto.auth.register.RegisterRequest;
import com.learn.Spring_Learn.exception.InputFieldException;
import com.learn.Spring_Learn.models.User;
import com.learn.Spring_Learn.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
@RequiredArgsConstructor
public class AuthenticationMapper {
    private final AuthenticationService authenticationService;
    private final CommonMapper commonMapper;

    public String registerUser(RegisterRequest registerRequest, BindingResult bindingResult) {
        System.out.println("==========" + registerRequest);
        System.out.println("==========" + bindingResult.hasErrors() + "======" + bindingResult);
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        User user = commonMapper.convertToEntity(registerRequest, User.class);
        return authenticationService.registerUser(user, registerRequest.getRepeat_password());
    }
}
