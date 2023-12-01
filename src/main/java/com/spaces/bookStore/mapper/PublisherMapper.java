package com.spaces.bookStore.mapper;

import com.spaces.bookStore.dto.PublisherDto;
import com.spaces.bookStore.entity.Publisher;

public class PublisherMapper {
    public static Publisher mapToEntity(PublisherDto publisherDto) {
        return Publisher.builder()
                .id(publisherDto.getId())
                .name(publisherDto.getName())
                .address(publisherDto.getAddress())
                .city(publisherDto.getCity())
                .state(publisherDto.getState())
                .zip(publisherDto.getZip())
                .books(publisherDto.getBooks())
                .build();
    }

    public static PublisherDto mapToDto(Publisher publisher) {
        return PublisherDto.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .address(publisher.getAddress())
                .city(publisher.getCity())
                .state(publisher.getState())
                .zip(publisher.getZip())
                .books(publisher.getBooks())
                .build();
    }
}
