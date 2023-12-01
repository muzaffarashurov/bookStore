package com.spaces.bookStore.service;

import com.spaces.bookStore.mapper.BookMapper;
import com.spaces.bookStore.model.BookModel;
import com.spaces.bookStore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    private final BookRepository bookRepository;

    public List<BookModel> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::mapFromEntityToModel)
                .toList();
    }

    public void save(BookModel bookModel) {
        bookRepository.save(bookMapper.mapFromModelToEntity(bookModel));
    }

    public Optional<BookModel> findById(Long id) {
        return bookRepository.findById(id)
                .map(book -> bookMapper.mapFromEntityToModel(book));
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
