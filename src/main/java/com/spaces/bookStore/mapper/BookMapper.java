package com.spaces.bookStore.mapper;

import com.spaces.bookStore.dto.BookDto;
import com.spaces.bookStore.entity.Book;

public class BookMapper {

    public static Book mapToEntity(BookDto bookDto) {

        return Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .isbn(bookDto.getIsbn())
                .publisher(bookDto.getPublisher())
                .authors(bookDto.getAuthors())
                .build();
    }

    public static BookDto mapToDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .publisher(book.getPublisher())
                .authors(book.getAuthors())
                .build();
    }
}
