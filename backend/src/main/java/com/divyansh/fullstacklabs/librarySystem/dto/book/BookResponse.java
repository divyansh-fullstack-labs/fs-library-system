package com.divyansh.fullstacklabs.librarySystem.dto.book;

import com.divyansh.fullstacklabs.librarySystem.dto.author.AuthorResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record BookResponse(
        Long id,
        String title,
        String isbn,
        String description,
        LocalDate publishedDate,
        String genre,
        Integer pages,
        String language,
        List<AuthorResponse> authors,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
