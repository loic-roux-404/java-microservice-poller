package com.example.multimodule.userapplication;

import com.example.multimodule.service.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserConstants.SLASHED_URI)
public class UserController extends AbstractCrudController<User> {


    public UserController(@Autowired UserService userService) {
        super(userService);
    }

    public ResponseEntity<User> login(String username, String password) {
        return ((UserService) crudService).login(username, password);
    }
}
