package com.learn.Spring_Learn.mapper;

import com.learn.Spring_Learn.dto.auth.register.RegisterRequest;
import com.learn.Spring_Learn.exception.InputFieldException;
import com.learn.Spring_Learn.models.User;
import com.learn.Spring_Learn.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Map;

import static com.learn.Spring_Learn.constants.Messages.PROVIDE_ALL_FIELDS_PLEASE;

@Component
@RequiredArgsConstructor
public class AuthenticationMapper {
    private final AuthenticationService authenticationService;
    private final CommonMapper commonMapper;

    public Map<String, Object> registerUser(RegisterRequest registerRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(PROVIDE_ALL_FIELDS_PLEASE, bindingResult);
        }
        User user = commonMapper.convertToEntity(registerRequest, User.class);
        return authenticationService.registerUser(user, registerRequest.getRepeat_password());
    }
}
