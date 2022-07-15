package com.example.multimodule.questionapplication.answer;

import com.example.multimodule.questionapplication.question.QuestionRepository;
import com.example.multimodule.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

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

    public ResponseEntity<Answer> findByQuestion(long questionId) {
        final var questionFromId = questionRepository.findById(questionId).orElseThrow();

        return ResponseEntity.of(answerRepository.findByQuestion(questionFromId));
    }

    public ResponseEntity<Boolean> isResponseIsCorrectForAnswer(long answer, boolean response) throws Exception {
        final var a = answerRepository.findById(answer);

        return a.map(e -> ResponseEntity.ok(
                    e.getCorrectAnswer() == response)
                )
                .orElse(ResponseEntity.ok(false));
    }
}
