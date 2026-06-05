package com.divyansh.fullstacklabs.librarySystem.repositories;

import com.divyansh.fullstacklabs.librarySystem.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepository extends JpaRepository<Book, Long> {

}
