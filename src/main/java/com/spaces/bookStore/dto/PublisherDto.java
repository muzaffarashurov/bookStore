package com.spaces.bookStore.dto;

import com.spaces.bookStore.entity.Book;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublisherDto {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Set<Book> books = new HashSet<>();
}
