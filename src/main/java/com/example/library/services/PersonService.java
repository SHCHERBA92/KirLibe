package com.example.library.services;

import com.example.library.entitys.Person;
import com.example.library.myExceptions.RepeaterElements;
import com.example.library.repository.PersonReposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonReposit personReposit;

    public void addNewPerson(Person person){
        if (personReposit.findByNumberOfStud(person.getNumberOfStud()).isPresent()){
            throw new RepeaterElements("студенческий № " + person.getNumberOfStud() + " уже зарегистрирован");
        }
        personReposit.saveAndFlush(person);
    }
}
