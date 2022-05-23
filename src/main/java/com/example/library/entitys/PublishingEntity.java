package com.example.library.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lib_publisher")
public class PublishingEntity {
    @Id
    @Column(name = "publisher_id")
    private Long id;

    private String namePublisher;

    private String address;

    private String numberPhone;

    @OneToMany(mappedBy = "publishingEntity", cascade = CascadeType.ALL)
    public Set<BookEntity> bookEntities;
}
