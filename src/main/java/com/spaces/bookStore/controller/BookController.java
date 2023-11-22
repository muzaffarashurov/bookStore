package com.spaces.bookStore.controller;

import com.spaces.bookStore.entity.Author;
import com.spaces.bookStore.entity.Book;
import com.spaces.bookStore.entity.Publisher;
import com.spaces.bookStore.service.AuthorService;
import com.spaces.bookStore.service.BookService;
import com.spaces.bookStore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;

    @GetMapping({"", "/"})
    public String getBook(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book/book";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<Publisher> publishers = publisherService.getAll();
        List<Author> authors = authorService.getAll();
        model.addAttribute("publishers", publishers);
        model.addAttribute("authors", authors);
        model.addAttribute("books", new Book());
        return "book/create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book) {
        bookService.save(book);
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

}
