package com.spaces.bookStore.controller;

import com.spaces.bookStore.service.MyBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/mybook")
public class MyBookController {

    private final MyBookService myBookService;

    @GetMapping({"", "/"})
    public String getMyBookList(Model model) {
        model.addAttribute("myBookList", myBookService.getAll());
        return "mybook/mybook";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        myBookService.deleteById(id);
        return "redirect:/mybook";
    }
}
