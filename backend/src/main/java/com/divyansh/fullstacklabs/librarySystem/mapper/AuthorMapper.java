package com.divyansh.fullstacklabs.librarySystem.mapper;

import com.divyansh.fullstacklabs.librarySystem.dto.author.AuthorDetailResponse;
import com.divyansh.fullstacklabs.librarySystem.dto.author.AuthorResponse;
import com.divyansh.fullstacklabs.librarySystem.entites.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponse toAuthorResponse(Author author);
    AuthorDetailResponse toAuthorDetailResponse(Author author);
    List<AuthorResponse> toAuthorResponseList(List<Author> authorList);
}
