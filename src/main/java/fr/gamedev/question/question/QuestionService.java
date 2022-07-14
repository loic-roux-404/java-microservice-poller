package fr.gamedev.question.question;

import fr.gamedev.question.restcommons.AbstractCrudService;
import fr.gamedev.question.user.User;
import fr.gamedev.question.user.UserConstants;
import fr.gamedev.question.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QuestionService extends AbstractCrudService<Question> {
    public QuestionService(
            @Autowired QuestionRepository userDisplayRepo
    ) {
        super(userDisplayRepo, QuestionConstants.URI);
    }
}
