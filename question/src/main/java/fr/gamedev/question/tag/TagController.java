package fr.gamedev.question.tag;

import fr.gamedev.core.restcommons.AbstractCrudController;
import fr.gamedev.core.restcommons.AbstractCrudService;
import fr.gamedev.question.user.User;
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
