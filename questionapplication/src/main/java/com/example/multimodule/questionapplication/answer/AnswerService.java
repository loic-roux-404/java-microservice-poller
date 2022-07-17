package com.example.multimodule.questionapplication.answer;

import com.example.multimodule.questionapplication.question.QuestionRepository;
import com.example.multimodule.library.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

    public ResponseEntity<Answer> findByQuestion(long id) {
        return ResponseEntity.of(Optional.of(this.answerRepository.findByQuestionId(id)));
    }
}
