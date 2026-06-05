package com.divyansh.fullstacklabs.librarySystem.service;

import com.divyansh.fullstacklabs.librarySystem.dto.author.AuthorDetailResponse;
import com.divyansh.fullstacklabs.librarySystem.dto.author.AuthorRequest;
import com.divyansh.fullstacklabs.librarySystem.dto.author.AuthorResponse;
import com.divyansh.fullstacklabs.librarySystem.entites.Author;
import com.divyansh.fullstacklabs.librarySystem.exception.ResourceNotFoundException;
import com.divyansh.fullstacklabs.librarySystem.mapper.AuthorMapper;
import com.divyansh.fullstacklabs.librarySystem.repositories.Authorrepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class AuthorService {
    Authorrepository authorrepository;
    AuthorMapper authorMapper;

    public AuthorResponse createAuthor(AuthorRequest request) {
        Author author = Author.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .bio(request.bio())
                .birthDate(request.birthDate())
                .nationality(request.nationality())
                .build();

        authorrepository.save(author);
        return authorMapper.toAuthorResponse(author);
    }

    public List<AuthorResponse> getAllAuthors() {
        List<Author> authors = authorrepository.findAll();
        return authorMapper.toAuthorResponseList(authors);
    }

    public AuthorDetailResponse getAuthorById(Long id) {
        Author author = authorrepository.findByIdWithBooks(id).orElseThrow(()-> new ResourceNotFoundException("Author",id));
        return authorMapper.toAuthorDetailResponse(author);
    }
}
