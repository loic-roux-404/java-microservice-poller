package com.example.multimodule.userapplication;

import com.example.multimodule.library.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<User> {
    public UserService(
            @Autowired UserRepository userDisplayRepo
    ) {
        super(userDisplayRepo, UserConstants.URI);
    }


    ResponseEntity<User> login(String username, String password) {
        return ResponseEntity.ok().build();
    }
}
