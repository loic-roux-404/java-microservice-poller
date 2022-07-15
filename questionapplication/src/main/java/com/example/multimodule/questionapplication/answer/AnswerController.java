package com.example.multimodule.questionapplication.answer;

import com.example.multimodule.service.AbstractCrudController;
import com.example.multimodule.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AnswerConstants.SLASHED_URI)
public class AnswerController extends AbstractCrudController<Answer> {
    public AnswerController(@Autowired AbstractCrudService<Answer> crudService) {
        super(crudService);
    }
}
