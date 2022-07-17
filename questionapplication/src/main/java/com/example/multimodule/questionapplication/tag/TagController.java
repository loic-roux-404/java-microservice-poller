package com.example.multimodule.questionapplication.tag;

import com.example.multimodule.library.AbstractCrudController;
import com.example.multimodule.library.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TagConstants.SLASHED_URI)
public class TagController extends AbstractCrudController<Tag> {
    public TagController(@Autowired AbstractCrudService<Tag> crudService) {
        super(crudService);
    }
}
