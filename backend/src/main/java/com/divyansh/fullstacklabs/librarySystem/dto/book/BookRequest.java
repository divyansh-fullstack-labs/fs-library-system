package com.divyansh.fullstacklabs.librarySystem.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.Set;

public record BookRequest(
        @NotBlank(message = "Title is required")
        String title,
        String isbn,
        String description,
        @NotBlank(message = "Publish Date is required")
        LocalDate publishedDate,
        String genre,
        @Positive(message = "Pages must be a positive number")
        Integer pages,
        String language,
        Set<Long> authorIds
        ) {
    public BookRequest{
        if (title    != null) title    = title.trim();
        if (language == null || language.isBlank()) language = "English";
    }
}
