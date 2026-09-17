package com.nexora.backend.user.dto;

import com.nexora.backend.user.User;
import java.time.Instant;

public record UserResponse (
    Long id,
    String name,
    String email,
    String timezone,
    String profilePicture,
    String role,
    String accountStatus,
    Instant lastLoginAt,
    Instant createdAt,
    Instant updatedAt
    ){

    public static UserResponse from(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getTimezone(),
                user.getProfilePicture(),
                user.getAccountStatus(),
                user.getRole(),
                user.getLastLoginAt(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
