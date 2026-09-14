package com.nexora.backend.user;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_users_email",
                        columnNames = "email"
                )
        }
)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String timezone;

    @Column(name= "profile_picture", nullable = true, length = 255)
    private String profilePicture;

    @Column(nullable = true, length = 100)
    private String role;

    @Column(name="account_status",nullable = true, length = 100)
    private String accountStatus;

    @Column(name="last_login_at",nullable = true, length = 100)
    private Instant lastLoginAat;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;
}
