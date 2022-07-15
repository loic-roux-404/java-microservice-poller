package com.example.multimodule.questionapplication.answer;

import com.example.multimodule.service.AbstractCrudService;
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
