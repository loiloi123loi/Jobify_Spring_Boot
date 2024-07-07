package com.learn.Spring_Learn.dto.auth.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static com.learn.Spring_Learn.constants.Messages.*;

@Data
public class RegisterRequest {
    @NotBlank(message = FULL_NAME_IS_REQUIRED)
    private String fullName;

    @NotBlank(message = LOCATION_IS_REQUIRED)
    private String location;

    @NotBlank(message = EMAIL_IS_REQUIRED)
    @Email(message = EMAIL_IS_INVALID_FORMAT)
    private String email;

    @NotBlank(message = PASSWORD_IS_REQUIRED)
    @Size(min = MINIMUM_PASSWORD_LENGTH, max = MAXIMUM_PASSWORD_LENGTH, message = PASSWORD_LENGTH_MUST_BETWEEN)
    private String password;

    @NotBlank(message = REPEAT_PASSWORD_IS_REQUIRED)
    @Size(min = MINIMUM_PASSWORD_LENGTH, max = MAXIMUM_PASSWORD_LENGTH, message = REPEAT_PASSWORD_LENGTH_MUST_BETWEEN)
    private String repeat_password;
}
