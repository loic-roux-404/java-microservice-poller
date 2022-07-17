package com.example.multimodule.leaderboardapplication.userchoice;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author loic-roux-404
 */
@RepositoryRestResource(collectionResourceRel = "userQuestion", path = "userQuestion")
public interface UserQuestionRepository extends PagingAndSortingRepository<UserQuestion, Long> {

    @Query("SELECT ua FROM UserQuestion ua WHERE ua.user = ?1 and ua.question = ?2")
    List<UserQuestion> findAllUserChoicesForQuestion(long user, long question);
}
