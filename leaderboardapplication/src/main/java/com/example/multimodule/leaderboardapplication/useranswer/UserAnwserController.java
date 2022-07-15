package com.example.multimodule.leaderboardapplication.useranswer;

import com.example.multimodule.service.AbstractCrudController;
import com.example.multimodule.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserAnswerConstants.SLASHED_URI)
public class UserAnwserController extends AbstractCrudController<UserAnswer> {
    public UserAnwserController(@Autowired AbstractCrudService<UserAnswer> crudService) {
        super(crudService);
    }
}
