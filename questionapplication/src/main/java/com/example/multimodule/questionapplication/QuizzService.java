package com.example.multimodule.questionapplication;

import com.example.multimodule.questionapplication.answer.AnswerService;
import com.example.multimodule.questionapplication.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizzService {

    private AnswerService answerService;

    private QuestionService questionService;

    @Autowired
    public QuizzService(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    public boolean isValidAnswerForQuestion(long answer, boolean response) throws Exception {
        final var a = answerService.find(answer);

        if (a == null) throw new Exception("not found answer");

        return a.getCorrectAnswer() == response;
    }
}
