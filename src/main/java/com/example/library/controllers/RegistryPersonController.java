package com.example.library.controllers;

import com.example.library.DTO.ConverterFactory;
import com.example.library.DTO.PersonDTO;
import com.example.library.entitys.Person;
import com.example.library.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/registry_Person")
public class RegistryPersonController {

    private Person person = null ;
    private final PersonService personService;

    public RegistryPersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String registryPerson(Model model) {
        model.addAttribute("person", new PersonDTO());
        return "registry_new_person";
    }

    @PostMapping()
    public String checkNewPerson(@ModelAttribute ("person") PersonDTO personDTO, Model model){
        person = ConverterFactory.convertPersonDTOtoEntity(personDTO);
        return "check_new_person";
    }

    @PostMapping("{number}/add_person")
    public String addNewPerson(@PathVariable Long number, @ModelAttribute ("person") PersonDTO personDTO, Model model){
        personService.addNewPerson(person);
        //TODO: сделать страницу подтверждающую, что пользователь зарегистрирован
        return "redirect:/registry_Person";
    }

}
