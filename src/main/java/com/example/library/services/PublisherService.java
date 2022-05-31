package com.example.library.services;

import com.example.library.entitys.PublishingEntity;
import com.example.library.repository.PublisherReposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PublisherService {
    private final PublisherReposit publisherReposit;

    public void addNewPublisher(PublishingEntity publishingEntity){
        var tempPublish = publisherReposit.findAll().contains(publishingEntity);
        if (!tempPublish){
            publisherReposit.save(publishingEntity);
        }
    }

    public PublishingEntity checkNewPublisher(PublishingEntity publishingEntity){
        var tempPublish = publisherReposit.findAll().contains(publishingEntity);
        if (!tempPublish){
            return publishingEntity;
        }else {
            return publisherReposit.findByNamePublisher(publishingEntity.getNamePublisher()).get();
        }
    }
}
