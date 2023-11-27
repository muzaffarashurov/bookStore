package com.spaces.bookStore.service;

import com.spaces.bookStore.entity.Book;
import com.spaces.bookStore.entity.MyBook;
import com.spaces.bookStore.repository.MyBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MyBookService {
    private final MyBookRepository myBookRepository;

    List<MyBook> myBookList = new ArrayList<>();

    public Optional<MyBook> findById(Long id) {
        return myBookRepository.findById(id);
    }

    public List<MyBook> getAll() {
        return myBookRepository.findAll();
    }

    public void save(MyBook book) {
        myBookRepository.save(book);
    }

    public void deleteById(Long id) {
        myBookRepository.deleteById(id);
    }

    public void copyBookToMyCart(Book book) {
        MyBook myBook = new MyBook();
        myBook.setTitle(book.getTitle());
        myBook.setIsbn(book.getIsbn());
        myBook.setPublisher(book.getPublisher());
        myBookRepository.save(myBook);
    }
}
