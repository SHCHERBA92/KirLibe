package com.example.library.repository;

import com.example.library.entitys.PublishingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherReposit extends JpaRepository<PublishingEntity, Long> {
    Optional<PublishingEntity> findByNamePublisher(String name);
}
