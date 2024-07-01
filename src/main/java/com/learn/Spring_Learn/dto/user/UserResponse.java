package com.learn.Spring_Learn.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String fullName;
    private String location;
    private String email;
    private Boolean verified;
    private LocalDate created_at;
}
