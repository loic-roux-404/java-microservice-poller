package com.example.multimodule.questionapplication.answer;

import com.example.multimodule.questionapplication.question.QuestionRepository;
import com.example.multimodule.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AnswerService extends AbstractCrudService<Answer> {
    protected final AnswerRepository answerRepository;
    protected final QuestionRepository questionRepository;

    public AnswerService(
            @Autowired AnswerRepository answerRepository,
            @Autowired QuestionRepository questionRepository
    ) {
        super(answerRepository, AnswerConstants.URI);
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public ResponseEntity<List<Answer>> findAllByQuestion(long questionId) {
        final var questionFromId = questionRepository.findById(questionId).orElseThrow();

        return ResponseEntity.ok(answerRepository.findAllByQuestion(questionFromId));
    }

    public ResponseEntity<Boolean> isResponseIsCorrectForAnswer(long answer, boolean response) throws Exception {
        final var a = answerRepository.findById(answer);

        return a.map(e -> ResponseEntity.ok(
                    e.getCorrectAnswer() == response)
                )
                .orElse(ResponseEntity.ok(false));
    }
}
