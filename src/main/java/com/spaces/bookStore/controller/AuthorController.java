package com.spaces.bookStore.controller;

import com.spaces.bookStore.entity.Author;
import com.spaces.bookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/author")
@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping({"", "/"})
    public String getAuthor(Model model) {
        model.addAttribute("authors", authorService.getAll());
        return "author/author";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/create";
    }

    @PostMapping("/create")
    public String createAuthor(@ModelAttribute("author") Author author) {
        authorService.save(author);
        return "redirect:/author";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        authorService.findById(id).ifPresent(author -> {
            model.addAttribute("author", author);
        });
        return "author/create";
    }

    @PutMapping("/update")
    public String updateAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/author";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteById(id);

        return "redirect:/author";
    }
}