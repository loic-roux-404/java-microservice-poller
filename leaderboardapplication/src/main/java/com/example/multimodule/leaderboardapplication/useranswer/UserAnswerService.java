package com.example.multimodule.leaderboardapplication.useranswer;

import com.example.multimodule.service.AbstractCrudService;
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