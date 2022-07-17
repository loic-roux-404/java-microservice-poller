package com.example.multimodule.questionapplication.answer;

import com.example.multimodule.library.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AnswerConstants.SLASHED_URI)
public class AnswerController extends AbstractCrudController<Answer> {

    private final AnswerService answerService;

    public AnswerController(@Autowired AnswerService crudService) {
        super(crudService);
        this.answerService = crudService;
    }

    @GetMapping("/find-by-question/{id}")
    public ResponseEntity<Answer> findByQuestion(@PathVariable long id) {
        return answerService.findByQuestion(id);
    }
}
