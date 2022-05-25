package com.example.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegictryBookController {

    @GetMapping("registryBook")
    public String registryNewBook(Model model){
        return "registry_new_books";
    }
}
