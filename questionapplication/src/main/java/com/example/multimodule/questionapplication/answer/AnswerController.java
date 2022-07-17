package com.example.multimodule.questionapplication.answer;

import com.example.multimodule.service.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AnswerConstants.SLASHED_URI)
public class AnswerController extends AbstractCrudController<Answer> {

    private final AnswerService answerService;

    public AnswerController(@Autowired AnswerService crudService) {
        super(crudService);
        this.answerService = crudService;
    }

    @GetMapping("/by-question/{id}")
    public ResponseEntity<List<Answer>> findAllByQuestion(@PathVariable long id) {
        return answerService.findAllByQuestion(id);
    }
}
