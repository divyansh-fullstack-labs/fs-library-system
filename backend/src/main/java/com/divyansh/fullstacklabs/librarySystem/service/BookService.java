package com.divyansh.fullstacklabs.librarySystem.service;

import com.divyansh.fullstacklabs.librarySystem.repositories.Authorrepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final Authorrepository authorrepository;



}
