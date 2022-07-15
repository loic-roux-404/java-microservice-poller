package com.example.multimodule.leaderboardapplication.useranswer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author loic-roux-404
 */
@RepositoryRestResource(collectionResourceRel = "userAnswer", path = "userAnswer")
public interface UserAnswerRepository extends PagingAndSortingRepository<UserAnswer, Long> {

    @Query("SELECT ua FROM UserAnswer ua WHERE ua.user = ?1 and ua.points > 0")
    List<UserAnswer> findByUserCorrect(long user);
}
