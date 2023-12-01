package com.spaces.bookStore.mapper;

import com.spaces.bookStore.dto.BookDto;
import com.spaces.bookStore.entity.Author;
import com.spaces.bookStore.entity.Book;
import com.spaces.bookStore.model.BookModel;
import com.spaces.bookStore.service.AuthorService;
import com.spaces.bookStore.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookMapper {

    private final PublisherService publisherService;
    private final AuthorService authorService;

    public BookModel mapFromDtoToModel(BookDto bookDto) {

        var publisher = publisherService.findById(bookDto.getPublisherId())
                .orElseThrow(() -> new RuntimeException("Publisher with id " + bookDto.getPublisherId() + " is not found"));

        Set<Author> authors = bookDto.getAuthorsIds().stream()
                .map(id -> authorService.findById(id).orElseThrow())
                .collect(Collectors.toSet());

        return BookModel.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .isbn(bookDto.getIsbn())
                .publisher(publisher)
                .authors(authors)
                .build();
    }

    public static BookDto mapFromModelToDto(BookModel book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .publisherId(book.getPublisher().getId())
                .authorsIds(book.getAuthors().stream().map(a -> a.getId()).collect(Collectors.toSet()))
                .build();
    }

    public Book mapFromModelToEntity(BookModel bookModel){
        return Book.builder()
                .id(bookModel.getId())
                .title(bookModel.getTitle())
                .isbn(bookModel.getIsbn())
                .publisher(bookModel.getPublisher())
                .authors(bookModel.getAuthors())
                .build();
    }

    public BookModel mapFromEntityToModel(Book book){
        return BookModel.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .publisher(book.getPublisher())
                .authors(book.getAuthors())
                .build();
    }
}
