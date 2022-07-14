package fr.gamedev.question.useranswer;

import fr.gamedev.question.restcommons.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerService extends AbstractCrudService<UserAnswer> {
    public UserAnswerService(
            @Autowired UserAnswerRepository userDisplayRepo
    ) {
        super(userDisplayRepo, UserAnswerConstants.URI);
    }
}
