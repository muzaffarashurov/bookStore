package com.spaces.bookStore.controller;

import com.spaces.bookStore.dto.BookDto;
import com.spaces.bookStore.entity.Author;
import com.spaces.bookStore.entity.Book;
import com.spaces.bookStore.entity.Publisher;
import com.spaces.bookStore.mapper.BookMapper;
import com.spaces.bookStore.service.AuthorService;
import com.spaces.bookStore.service.BookService;
import com.spaces.bookStore.service.MyBookService;
import com.spaces.bookStore.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    private final PublisherService publisherService;

    private final AuthorService authorService;

    private final MyBookService myBookService;


    @GetMapping({"", "/"})
    public String getBook(Model model) {

        var list = bookService.getAll().stream()
                .map(BookMapper::mapToDto)
                .toList();

        model.addAttribute("books", list);
        return "book/book";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<Publisher> publishers = publisherService.getAll();
        List<Author> authors = authorService.getAll();
        model.addAttribute("publishers", publishers);
        model.addAttribute("authors", authors);
        model.addAttribute("books", new BookDto());
        return "book/create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute BookDto book) {
        var mapped = BookMapper.mapToEntity(book);
        bookService.save(mapped);
        return "redirect:/book";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        List<Publisher> publishers = publisherService.getAll();
        List<Author> authors = authorService.getAll();
        model.addAttribute("publishers", publishers);
        model.addAttribute("authors", authors);
        bookService.findById(id).ifPresent(book -> {
            model.addAttribute("books", book);

            model.addAttribute("selectedPublisherId", book.getPublisher().getId());
            System.out.println("Publisher ID " + book.getPublisher().getId());
            var authorIds = book.getAuthors().stream().map(a -> a.getId()).toList();
            model.addAttribute("authorsList", authorIds);
            System.out.println("Author ID " + authorIds);

        });
        return "book/create";
    }


    @PutMapping("update")
    public String updateBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/book";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);

        return "redirect:/book";
    }

    @GetMapping("/copy/{id}")
    public String addBookToMyCart(@PathVariable("id") Long id) {
        Optional<Book> mybook = bookService.findById(id);
        if (mybook.isPresent()) {
            myBookService.copyBookToMyCart(mybook.get());
        }
        return "redirect:/book";
    }


}
