package com.nexora.backend.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import  jakarta.validation.constraints.Size;

public record CreateUserRequest (
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 character")
    String name,

    @NotBlank(message = "Email is required")
    @Email(message = "Please Provide a valid email")
    @Size(max = 255, message = "Email cannot exceed 255 character")
    String email,

    @NotBlank(message = "Timezone is required")
    String timezone
    )
{
}
