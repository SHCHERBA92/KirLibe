package com.example.library.controllers;

import com.example.library.DTO.PersonDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping ("/registry_Person")
public class RegistryPersonController {

    @GetMapping()
    public String registryPerson(Model model) {
        model.addAttribute("person", new PersonDTO());
        return "registry_new_person";
    }

    @PostMapping()
    public String registryNewPerson(@RequestParam String lastNamePerson,
                                    @RequestParam String firstNamePerson,
                                    @RequestParam String secondNamePerson,
                                    @RequestParam Integer numberStudTicket,
                                    @RequestParam String phonePerson, Model model){
        System.out.println(lastNamePerson);
        return null;
    }

}
