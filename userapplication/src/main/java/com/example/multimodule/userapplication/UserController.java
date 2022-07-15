package com.example.multimodule.userapplication;

import com.example.multimodule.service.AbstractCrudController;
import com.example.multimodule.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserConstants.SLASHED_URI)
public class UserController extends AbstractCrudController<User> {
    public UserController(@Autowired AbstractCrudService<User> crudService) {
        super(crudService);
    }
}
