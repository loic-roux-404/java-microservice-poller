package fr.gamedev.question.answer;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.question.Question;

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
  Optional<Answer> findByQuestion(Question question);
}
