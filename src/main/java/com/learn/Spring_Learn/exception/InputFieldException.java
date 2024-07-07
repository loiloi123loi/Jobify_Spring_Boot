package com.learn.Spring_Learn.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class InputFieldException extends RuntimeException {
    private final String inputFieldMessage;
    private final BindingResult bindingResult;
    private final Map<String, String> errorsMap;

    public InputFieldException(String inputFieldMessage, BindingResult bindingResult) {
        this.inputFieldMessage = inputFieldMessage;
        this.bindingResult = bindingResult;
        this.errorsMap = bindingResult.getFieldErrors()
                                      .stream()
                                      .collect(Collectors.toMap(FieldError::getField, error -> Objects.requireNonNullElse(error.getDefaultMessage(), "")));
    }
}