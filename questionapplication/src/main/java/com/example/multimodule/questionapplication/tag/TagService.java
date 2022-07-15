package com.example.multimodule.questionapplication.tag;

import com.example.multimodule.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TagService extends AbstractCrudService<Tag> {
    public TagService(
            @Autowired TagRepository userDisplayRepo
    ) {
        super(userDisplayRepo, TagConstants.URI);
    }
}
