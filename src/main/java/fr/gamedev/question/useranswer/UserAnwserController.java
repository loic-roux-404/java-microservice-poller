package fr.gamedev.question.useranswer;

import fr.gamedev.question.restcommons.AbstractCrudController;
import fr.gamedev.question.restcommons.AbstractCrudService;
import fr.gamedev.question.user.User;
import fr.gamedev.question.user.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserAnswerConstants.SLASHED_URI)
public class UserAnwserController extends AbstractCrudController<User> {
    public UserAnwserController(@Autowired AbstractCrudService<User> crudService) {
        super(crudService);
    }
}
