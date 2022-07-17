package com.example.multimodule.questionapplication.answer;

import java.util.List;
import java.util.Optional;

import com.example.multimodule.questionapplication.question.Question;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author djer1
 */
@RepositoryRestResource(collectionResourceRel = "answer", path = "answer")
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long> {

  /**
   * Find by question.
   * @param question The question
   * @return (Optional)
   */
  List<Answer> findAllByQuestion(Question question);
}
