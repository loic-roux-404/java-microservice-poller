package fr.gamedev.question.tag;

import fr.gamedev.question.restcommons.AbstractCrudController;
import fr.gamedev.question.restcommons.AbstractCrudService;
import fr.gamedev.question.user.User;
import fr.gamedev.question.user.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TagConstants.SLASHED_URI)
public class TagController extends AbstractCrudController<User> {
    public TagController(@Autowired AbstractCrudService<User> crudService) {
        super(crudService);
    }
}
