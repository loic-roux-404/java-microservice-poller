package com.example.multimodule.questionapplication.question;

import com.example.multimodule.library.AbstractCrudController;
import com.example.multimodule.library.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(QuestionConstants.SLASHED_URI)
public class QuestionController extends AbstractCrudController<Question> {
    public QuestionController(@Autowired AbstractCrudService<Question> crudService) {
        super(crudService);
    }
}
