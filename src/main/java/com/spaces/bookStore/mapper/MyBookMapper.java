package com.spaces.bookStore.mapper;

import com.spaces.bookStore.dto.MyBookDto;
import com.spaces.bookStore.entity.MyBook;

public class MyBookMapper {
    public static MyBook mapToEntity(MyBookDto myBookDto) {
        return MyBook.builder()
                .id(myBookDto.getId())
                .title(myBookDto.getTitle())
                .isbn(myBookDto.getIsbn())
                .publisher(myBookDto.getPublisher())
                .build();
    }

    public static MyBookDto mapToDto(MyBook myBook) {
        return MyBookDto.builder()
                .id(myBook.getId())
                .title(myBook.getTitle())
                .isbn(myBook.getIsbn())
                .publisher(myBook.getPublisher())
                .build();
    }
}