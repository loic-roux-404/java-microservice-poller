package fr.gamedev.question.question;

import fr.gamedev.core.restcommons.AbstractCrudService;
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
