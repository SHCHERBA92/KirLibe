package com.example.library.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping ("/registry_Person")
public class RegistryPersonController {

    @GetMapping()
    public String registryPerson()
    {
        return "registry_new_person";
    }
}
