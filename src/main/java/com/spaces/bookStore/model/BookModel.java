package com.spaces.bookStore.model;

import com.spaces.bookStore.entity.Author;
import com.spaces.bookStore.entity.Publisher;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class BookModel {
    private Long id;
    private String title;
    private String isbn;
    private Publisher publisher;
    private Set<Author> authors = new HashSet<>();

}
