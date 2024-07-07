package com.learn.Spring_Learn.models;

import com.learn.Spring_Learn.enums.AuthProvider;
import com.learn.Spring_Learn.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "verified", nullable = false)
    private Boolean verified;

    @Column(name = "provider", nullable = false)
    private AuthProvider provider;

    @Column(name = "activeToken")
    private String activateToken;

    @Column(name = "forgotPasswordToken")
    private String forgotPasswordToken;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @PrePersist
    protected void onCreate() {
        LocalDate now = LocalDate.now();
        this.createdAt = now;
        this.updatedAt = now;
        if (this.verified == null) {
            this.verified = false;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDate.now();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(this.id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
