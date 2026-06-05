package com.divyansh.fullstacklabs.librarySystem.dto.book;

import java.time.LocalDate;

public record BookSummary(
        Long id,
        String title,
        String isbn,
        LocalDate publishedDate,
        String genre
) {
}
