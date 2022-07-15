package com.example.multimodule.leaderboardapplication.useranswer;

import com.example.multimodule.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerService extends AbstractCrudService<UserAnswer> {
    UserAnswerRepository userAnswerRepository;

    public UserAnswerService(
            @Autowired UserAnswerRepository userDisplayRepo
    ) {
        super(userDisplayRepo, UserAnswerConstants.URI);
    }

    public List<UserAnswer> getAlreadyAnsweredCorrect(long user, long answer) {
        // TODO  @Query("SELECT ua FROM UserAnswer ua WHERE ua.user = ?1 and ua.answer.question = ?2 and ua.points > 0")
        final var userAnwsers = userAnswerRepository.findByUserCorrect(user);

        return List.of();
    }
}
