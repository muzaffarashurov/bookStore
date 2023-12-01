package com.spaces.bookStore.dto;

import com.spaces.bookStore.entity.Publisher;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyBookDto {
    private Long id;
    private String title;
    private String isbn;
    private Publisher publisher;
}