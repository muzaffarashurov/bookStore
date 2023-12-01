package com.spaces.bookStore.dto;

import com.spaces.bookStore.entity.Book;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {
    private Long id;

    private String firstName;

    private String lastName;

    private Set<Book> books = new HashSet<>();
}
