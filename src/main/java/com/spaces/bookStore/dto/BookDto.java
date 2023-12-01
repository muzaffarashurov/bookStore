package com.spaces.bookStore.dto;

import com.spaces.bookStore.entity.Author;
import com.spaces.bookStore.entity.Publisher;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String isbn;
    private Publisher publisher;
    private Set<Author> authors = new HashSet<>();
}
