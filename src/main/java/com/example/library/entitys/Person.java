package com.example.library.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lib_person")
public class Person {
    @Id
    @Column(name = "person_id")
    private Long id;

    private String firstNamePerson;

    private String lastNamePerson;

    private String numberPhone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<BookEntity> bookEntities;
}
