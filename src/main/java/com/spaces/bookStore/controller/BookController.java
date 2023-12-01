package com.spaces.bookStore.controller;

import com.spaces.bookStore.dto.AuthorDto;
import com.spaces.bookStore.dto.BookDto;
import com.spaces.bookStore.dto.PublisherDto;
import com.spaces.bookStore.mapper.AuthorMapper;
import com.spaces.bookStore.mapper.BookMapper;
import com.spaces.bookStore.mapper.PublisherMapper;
import com.spaces.bookStore.model.BookModel;
import com.spaces.bookStore.service.AuthorService;
import com.spaces.bookStore.service.BookService;
import com.spaces.bookStore.service.MyBookService;
import com.spaces.bookStore.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final MyBookService myBookService;
    private final BookMapper bookMapper;

    @GetMapping({"", "/"})
    public String getBook(Model model) {

        var list = bookService.getAll().stream()
                .map(BookMapper::mapFromModelToDto)
                .toList();
        var publishers = publisherService.getAll().stream()
                        .map(PublisherMapper::mapToDto)
                                .toList();

        model.addAttribute("books", list);
        model.addAttribute("publishers", publishers);
        return "book/book";
    }

    @GetMapping("/create")
    public String createForm(Model model) {

        List<PublisherDto> publishers = publisherService.getAll().stream()
                .map(PublisherMapper::mapToDto)
                .toList();

        List<AuthorDto> authors = authorService.getAll().stream()
                .map(AuthorMapper::mapToDto)
                .toList();

        model.addAttribute("publishers", publishers);
        model.addAttribute("authors", authors);
        model.addAttribute("books", new BookDto());
        return "book/create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute BookDto book) {

        var mapped = bookMapper.mapFromDtoToModel(book);
        bookService.save(mapped);

        return "redirect:/book";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {

        List<PublisherDto> publishers = publisherService.getAll().stream()
                .map(PublisherMapper::mapToDto)
                .toList();

        List<AuthorDto> authors = authorService.getAll().stream()
                .map(AuthorMapper::mapToDto)
                .toList();

        model.addAttribute("publishers", publishers);
        model.addAttribute("authors", authors);
        bookService.findById(id).ifPresent(book -> {
            var b = bookMapper.mapFromModelToDto(book);
            model.addAttribute("books", b);

            model.addAttribute("selectedPublisherId", b.getPublisherId());
            System.out.println("Publisher ID " + b.getPublisherId());
            var authorIds = b.getAuthorsIds();
            model.addAttribute("authorsList", authorIds);
            System.out.println("Author ID " + authorIds);

        });
        return "book/create";
    }

    @PutMapping("update")
    public String updateBook(@ModelAttribute BookDto bookDto) {
        var book = bookMapper.mapFromDtoToModel(bookDto);
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
        Optional<BookModel> mybook = bookService.findById(id);

        if (mybook.isPresent()) {
            myBookService.copyBookToMyCart(mybook.get());
        }
        return "redirect:/book";
    }

}
