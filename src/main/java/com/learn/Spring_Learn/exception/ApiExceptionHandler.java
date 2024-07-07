package com.learn.Spring_Learn.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

import static com.learn.Spring_Learn.utils.Template.createResponse;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(InputFieldException.class)
    public ResponseEntity<Map<String, Object>> handleInputFieldException(InputFieldException exception) {
        InputFieldException inputFieldException = new InputFieldException(exception.getInputFieldMessage(), exception.getBindingResult());
        return ResponseEntity.badRequest()
                             .body(createResponse(inputFieldException.getInputFieldMessage(), inputFieldException.getErrorsMap()));
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<Map<String, Object>> handleEmailException(EmailException emailException) {
        return ResponseEntity.badRequest()
                             .body(createResponse(emailException.getEmailError()));
    }
}
