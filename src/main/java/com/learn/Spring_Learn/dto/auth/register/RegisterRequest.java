package com.learn.Spring_Learn.dto.auth.register;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class RegisterRequest {
    @NotBlank(message = "1.1")
    @NotEmpty(message = "1.2")
    @NotNull(message = "1.3")
    private String fullName;

    @NotBlank(message = "1.1")
    @NotEmpty(message = "1.2")
    @NotNull(message = "1.3")
    private String location;

    @Email(message = "3")
    @NotBlank(message = "1.1")
    @NotEmpty(message = "1.2")
    @NotNull(message = "1.3")
    private String email;

    @Size(min = 6, max = 16, message = "5")
    private String password;

    @Size(min = 6, max = 16, message = "6")
    private String repeat_password;
}
