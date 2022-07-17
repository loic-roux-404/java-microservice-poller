package com.example.multimodule.questionapplication.category;

import com.example.multimodule.library.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryService extends AbstractCrudService<Category> {
    public CategoryService(
            @Autowired CategoryRepository userDisplayRepo
    ) {
        super(userDisplayRepo, CategoryConstants.URI);
    }
}
