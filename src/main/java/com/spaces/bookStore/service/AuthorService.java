package com.spaces.bookStore.service;

import com.spaces.bookStore.entity.Author;
import com.spaces.bookStore.entity.Book;
import com.spaces.bookStore.repository.AuthorRepository;
import com.spaces.bookStore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public synchronized void save(Author author) {
        authorRepository.save(author);
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public void deleteById(Long id) {
        authorRepository.findById(id).ifPresent(author -> {
            List<Book> books = bookRepository.findByAuthors(author);
            books.stream().forEach(book -> {
                book.getAuthors().remove(author);
                bookRepository.save(book);
            });
        });
        authorRepository.deleteById(id);
    }
}
