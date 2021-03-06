package com.example.library.services;

import com.example.library.entitys.PublishingEntity;
import com.example.library.repository.PublisherReposit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService {
    private final PublisherReposit publisherReposit;

    public void saveNewPublisher(PublishingEntity publishingEntity) {
        var tempPublish = publisherReposit.findAll().contains(publishingEntity);
        if (!tempPublish) {
            publisherReposit.save(publishingEntity);
        }
    }

    public PublishingEntity checkNewPublisher(PublishingEntity publishingEntity) {
        var tempPublish = publisherReposit.findAll().contains(publishingEntity);
        if (!tempPublish) {
            return publishingEntity;
        } else {
            return publisherReposit.findByNamePublisher(publishingEntity.getNamePublisher()).get();
        }
    }

    public List<PublishingEntity> getPagesOfPublishers() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        return publisherReposit.findAll(pageRequest).getContent();
    }
}
