package com.example.multimodule.questionapplication.question;

import com.example.multimodule.library.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QuestionService extends AbstractCrudService<Question> {

    public QuestionService(
            @Autowired QuestionRepository repo
    ) {
        super(repo, QuestionConstants.URI);
    }
}
