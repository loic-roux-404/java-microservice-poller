package com.example.multimodule.leaderboardapplication.userchoice;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author loic-roux-404
 */
@RepositoryRestResource(collectionResourceRel = "userChoice", path = "userChoice")
public interface UserChoiceRepository extends PagingAndSortingRepository<UserChoice, Long> {

    @Query("SELECT ua FROM UserChoice ua WHERE ua.user = ?1 and ua.question = ?2")
    List<UserChoice> findAllUserChoicesForQuestion(long user, long question);
}
