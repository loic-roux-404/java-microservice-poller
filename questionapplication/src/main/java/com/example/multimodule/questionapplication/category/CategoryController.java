package com.example.multimodule.questionapplication.category;

import com.example.multimodule.service.AbstractCrudController;
import com.example.multimodule.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CategoryConstants.SLASHED_URI)
public class CategoryController extends AbstractCrudController<Category> {
    public CategoryController(@Autowired AbstractCrudService<Category> crudService) {
        super(crudService);
    }
}
