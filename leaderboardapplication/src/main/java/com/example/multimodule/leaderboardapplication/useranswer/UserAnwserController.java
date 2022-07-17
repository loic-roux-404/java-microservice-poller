package com.example.multimodule.leaderboardapplication.useranswer;

import com.example.multimodule.service.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserAnswerConstants.SLASHED_URI)
public class UserAnwserController extends AbstractCrudController<UserAnswer> {
    UserAnswerService service;

    public UserAnwserController(@Autowired UserAnswerService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/do-answer-to-question")
    public String doAnswerToQuestion(
            @RequestParam final long questionId,
            @RequestParam final Boolean answer,
            @RequestParam final long userId
    ) {
        return this.service.doAnswerToQuestion(questionId, answer, userId);
    }
}
