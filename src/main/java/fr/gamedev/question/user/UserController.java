package fr.gamedev.question.user;

import fr.gamedev.question.restcommons.AbstractCrudController;
import fr.gamedev.question.restcommons.AbstractCrudService;
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
