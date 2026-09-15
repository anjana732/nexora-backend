package com.nexora.backend.user;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users")
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

    @Column(name= "profile_picture", length = 255)
    private String profilePicture;

    @Column(length = 100)
    private String role;

    @Column(name="account_status", length = 100)
    private String accountStatus;

    @Column(name="last_login_at")
    private Instant lastLoginAt;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    protected User() {

    }

    public User(String name, String email, String timezone){
        this.name = name;
        this.email = email;
        this.timezone = timezone;
    }

    @PrePersist
    protected void onCreate(){
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = Instant.now();
    }

    public void updateProfile(String name, String timezone){
        this.name = name;
        this.timezone = timezone;
    }

    public void updateProfilePicture(String profilePicture){
        this.profilePicture = profilePicture;
    }

    public void updateLastLoginAt(){
        this.lastLoginAt = Instant.now();
    }

    public void changePassword(String password){
        this.password = password;
    }

    public void deactivateAccount(){
        this.accountStatus = "INACTIVE";
    }

    public void activateAccount(){
        this.accountStatus = "ACTIVE";
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getRole() {
        return role;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public Instant getLastLoginAt() {
        return lastLoginAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
