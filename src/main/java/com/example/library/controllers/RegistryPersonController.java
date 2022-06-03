package com.example.library.controllers;

import com.example.library.DTO.ConverterFactory;
import com.example.library.DTO.PersonDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String registryNewPerson(@ModelAttribute ("person") PersonDTO personDTO, Model model){

        var person = ConverterFactory.convertPersonDTOtoEntity(personDTO);
        return "check_new_person";
    }

}
