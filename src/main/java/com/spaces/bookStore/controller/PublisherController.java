package com.spaces.bookStore.controller;

import com.spaces.bookStore.entity.Publisher;
import com.spaces.bookStore.repository.PublisherRepository;
import com.spaces.bookStore.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/publisher")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping({"", "/"})
    public String getPublisher(Model model) {
        model.addAttribute("publishers", publisherService.getAll());
        return "publisher/publisher";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("publishers", new Publisher());
        return "publisher/create";
    }

    @PostMapping("/create")
    public String createPublisher(@ModelAttribute Publisher publisher) {
        publisherService.save(publisher);
        return "redirect:/publisher";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        publisherService.findById(id).ifPresent(publisher -> {
            model.addAttribute("publishers", publisher);
        });
        return "publisher/create";
    }

    @PutMapping("/update")
    public String updatePublisher(@ModelAttribute Publisher publisher) {
        log.info(publisher.toString());
        publisherService.save(publisher);
        return "redirect:/publisher";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.deleteById(id);
        return "redirect:/publisher";
    }

}
