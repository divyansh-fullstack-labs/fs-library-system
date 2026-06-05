package com.divyansh.fullstacklabs.librarySystem.dto.author;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AuthorResponse(
        Long id,
        String firstName,
        String lastName,
        String fullName,
        String email,
        String bio,
        LocalDate birtDate,
        String nationality,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
