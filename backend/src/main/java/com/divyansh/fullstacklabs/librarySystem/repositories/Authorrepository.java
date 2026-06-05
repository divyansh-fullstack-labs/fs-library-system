package com.divyansh.fullstacklabs.librarySystem.repositories;

import com.divyansh.fullstacklabs.librarySystem.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Authorrepository extends JpaRepository<Author, Long> {
    /**
     * Find authors whose first or last name contains the search term.
     * Generated SQL: WHERE LOWER(first_name) LIKE %term% OR LOWER(last_name) LIKE %term%
     */
    List<Author> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName
    );

    /**
     * Find by exact email (unique field, so Optional is correct return type).
     */
    Optional<Author> findByEmailIgnoreCase(String email);

    List<Author> findByNationalityIgnoreCase(String nationality);

    /**
     * Find all books written by a specific author.
     * JOIN FETCH eagerly loads books in the same query (avoids N+1 problem).
     */
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id = :authorId")
    Optional<Author> findByIdWithBooks(@Param("authorId") Long authorId);

    /**
     * Search authors by full name using a single search term.
     * CONCAT joins first and last name for matching.
     */
    @Query("SELECT a FROM Author a WHERE " +
            "LOWER(CONCAT(a.firstName, ' ', a.lastName)) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Author> searchByFullName(@Param("name") String name);

    /**
     * Find all authors who have written at least one book.
     */
    @Query("SELECT DISTINCT a FROM Author a JOIN a.books b")
    List<Author> findAuthorsWithBooks();

}
