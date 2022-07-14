package fr.gamedev.question.answer;

import fr.gamedev.core.restcommons.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AnswerService extends AbstractCrudService<Answer> {
    public AnswerService(
            @Autowired AnswerRepository userDisplayRepo
    ) {
        super(userDisplayRepo, AnswerConstants.URI);
    }
}
