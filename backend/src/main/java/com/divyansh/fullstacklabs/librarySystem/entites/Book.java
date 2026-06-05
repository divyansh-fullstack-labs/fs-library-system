package com.divyansh.fullstacklabs.librarySystem.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;

    @Column(unique = true)
    private String isbn;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String genre;
    private Integer pages;

    @Builder.Default
    private String language = "English";

    /**
     * INVERSE side of ManyToMany.
     * mappedBy refers to the field name in the OWNER entity (Author.books).
     * JPA will NOT create a second join table — it reuses book_author.
     */

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    @Builder.Default
    private Set<Author> authors = new HashSet<>();



    @NotNull(message = "Published date is required")
    @Column(name = "published_date", nullable = false)
    private LocalDate publishedDate;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
