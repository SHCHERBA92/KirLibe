package com.example.library.repository;

import com.example.library.entitys.PublishingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherReposit extends JpaRepository<PublishingEntity, Long> {
}
