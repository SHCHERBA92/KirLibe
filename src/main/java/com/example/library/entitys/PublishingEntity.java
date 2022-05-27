package com.example.library.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lib_publisher")
public class PublishingEntity {

    public PublishingEntity(String namePublisher, String address, String numberPhone) {
        this.namePublisher = namePublisher;
        this.address = address;
        this.numberPhone = numberPhone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long id;

    private String namePublisher;

    private String address;

    private String numberPhone;

    @OneToMany(mappedBy = "publishingEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<BookEntity> bookEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishingEntity that = (PublishingEntity) o;
        return Objects.equals(namePublisher, that.namePublisher) && Objects.equals(address, that.address) && Objects.equals(numberPhone, that.numberPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePublisher, address, numberPhone);
    }
}
