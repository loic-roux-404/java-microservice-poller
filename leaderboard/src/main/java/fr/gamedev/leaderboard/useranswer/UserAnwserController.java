package fr.gamedev.leaderboard.useranswer;

import fr.gamedev.core.restcommons.AbstractCrudController;
import fr.gamedev.core.restcommons.AbstractCrudService;
import fr.gamedev.question.user.User;
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
