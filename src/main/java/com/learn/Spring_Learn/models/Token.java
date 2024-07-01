package com.learn.Spring_Learn.models;

import com.learn.Spring_Learn.enums.VerifyToken;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "user_id", unique = true, nullable = false)
    private Integer user_id;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "type", nullable = false)
    private VerifyToken type;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiry_date;
}
