package com.spaces.bookStore.model;

import com.spaces.bookStore.entity.Book;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class AuthorModel {
    private Long id;

    private String firstName;

    private String lastName;

    private Set<BookModel> books = new HashSet<>();
}
