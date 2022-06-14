package com.example.library.DTO;

import com.example.library.entitys.BookEntity;
import com.example.library.entitys.Person;
import org.modelmapper.ModelMapper;

public class ConverterFactory {
    static ModelMapper modelMapper = new ModelMapper();


    static public Person convertPersonDTOtoEntity(PersonDTO personDTO){
        var person = modelMapper.map(personDTO, Person.class);
        person.setFirstNamePerson(personDTO.getFirstNamePerson() + " " + personDTO.getSecondNamePerson());
        return person;
    }

    static public BookDTO convertBookEntityToDTO(BookEntity entity){
        return modelMapper.map(entity, BookDTO.class);
    }
}
