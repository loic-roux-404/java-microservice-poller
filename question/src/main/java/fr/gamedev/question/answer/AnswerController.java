package fr.gamedev.question.answer;

import fr.gamedev.core.restcommons.AbstractCrudController;
import fr.gamedev.core.restcommons.AbstractCrudService;
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
