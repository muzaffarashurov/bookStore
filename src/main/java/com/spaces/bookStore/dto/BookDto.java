package com.spaces.bookStore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spaces.bookStore.entity.Author;
import com.spaces.bookStore.entity.Publisher;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class BookDto {

    private Long id;
    @JsonProperty("titlee")
    private String title;
    private String isbn;
    private Publisher publisher;
    private Set<Author> authors = new HashSet<>();

}
