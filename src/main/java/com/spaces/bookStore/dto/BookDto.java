package com.spaces.bookStore.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String isbn;
    private Long publisherId;
    private Set<Long> authorsIds = new HashSet<>();
}
