package com.spaces.bookStore.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class PublisherModel {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Set<BookModel> books = new HashSet<>();
}
