package com.divyansh.fullstacklabs.librarySystem.dto.author;

import com.divyansh.fullstacklabs.librarySystem.dto.book.BookSummary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record AuthorDetailResponse(
        Long id,
        String firstName,
        String lastName,
        String fullName,
        String email,
        String bio,
        LocalDate birthDate,
        String nationality,
        List<BookSummary> books,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
