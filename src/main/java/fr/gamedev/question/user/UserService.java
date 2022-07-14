package fr.gamedev.question.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserService {
    private UserRepository userRepo;

    public UserService(@Autowired UserRepository userRepo) {
        this.userRepo = userRepo;
    }



}
