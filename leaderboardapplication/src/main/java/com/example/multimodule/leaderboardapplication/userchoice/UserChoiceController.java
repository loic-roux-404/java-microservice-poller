package com.example.multimodule.leaderboardapplication.userchoice;

import com.example.multimodule.library.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(UserChoiceConstants.SLASHED_URI)
@RestController
public class UserChoiceController extends AbstractCrudController<UserChoice> {
    private final UserChoiceService service;

    public UserChoiceController(@Autowired UserChoiceService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/do-answer-to-question")
    public String doAnswerToQuestion(
            @RequestParam final long questionId,
            @RequestParam final Boolean answer,
            @RequestParam final long userId
    ) throws Exception {
        return this.service.doAnswerToQuestion(questionId, answer, userId);
    }
}
