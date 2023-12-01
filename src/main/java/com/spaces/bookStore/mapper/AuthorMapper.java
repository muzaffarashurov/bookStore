package com.spaces.bookStore.mapper;

import com.spaces.bookStore.dto.AuthorDto;
import com.spaces.bookStore.entity.Author;

public class AuthorMapper {
    public static Author mapToEntity(AuthorDto authorDto) {
        return Author.builder()
                .id(authorDto.getId())
                .firstName(authorDto.getFirstName())
                .lastName(authorDto.getLastName())
                .books(authorDto.getBooks())
                .build();
    }

    public static AuthorDto mapToDto(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .books(author.getBooks())
                .build();
    }
}
