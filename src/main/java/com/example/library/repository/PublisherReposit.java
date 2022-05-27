package com.example.library.repository;

import com.example.library.entitys.PublishingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherReposit extends JpaRepository<PublishingEntity, Long> {
}
