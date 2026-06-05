package com.divyansh.fullstacklabs.librarySystem.dto.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AuthorRequest(
        @NotBlank(message = "First name is required")
        String firstName,
        @NotBlank(message = "Last name is required")
        String lastName,
        @Email(message = "Must be a valid email address")
        String email,
        String bio,
        LocalDate birthDate,
        String nationality) {
    public AuthorRequest {
        if (firstName != null) firstName = firstName.trim();
        if (lastName  != null) lastName  = lastName.trim();
        if (email     != null) email     = email.trim().toLowerCase();
    }
}
