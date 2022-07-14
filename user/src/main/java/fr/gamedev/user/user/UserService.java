package fr.gamedev.user.user;

import fr.gamedev.core.restcommons.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<User> {
    public UserService(
            @Autowired UserRepository userDisplayRepo
    ) {
        super(userDisplayRepo, UserConstants.URI);
    }
}
