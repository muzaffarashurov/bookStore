package com.spaces.bookStore.service;

import com.spaces.bookStore.entity.Book;
import com.spaces.bookStore.entity.Publisher;
import com.spaces.bookStore.repository.BookRepository;
import com.spaces.bookStore.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    private final BookRepository bookRepository;

    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Optional<Publisher> findById(Long id) {
        return publisherRepository.findById(id);
    }

    public void deleteById(Long id) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);
        if (publisherOptional.isPresent()) {
            Publisher publisher = publisherOptional.get();

            List<Book> books = bookRepository.findByPublisher(publisher);
            books.forEach(book -> {
                book.setPublisher(null); // Удалить связь с издателем
                bookRepository.save(book);
            });

            publisherRepository.delete(publisher);
        }
    }
}
