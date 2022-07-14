package fr.gamedev.question.repository;

import fr.gamedev.question.data.Question;
import fr.gamedev.question.data.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.UserAnswer;

import java.util.List;

/**
 * @author loic-roux-404
 */
@RepositoryRestResource(collectionResourceRel = "userAnswer", path = "userAnswer")
public interface UserAnswerRepository extends PagingAndSortingRepository<UserAnswer, Long> {

    @Query("SELECT ua FROM UserAnswer ua WHERE ua.user = ?1 and ua.answer.question = ?2 and ua.points > 0")
    List<UserAnswer> getAlreadyAnsweredCorrect(User user, Question question);
}
