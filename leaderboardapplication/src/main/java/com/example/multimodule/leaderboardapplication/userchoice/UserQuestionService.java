package com.example.multimodule.leaderboardapplication.userchoice;

import com.example.multimodule.library.AbstractCrudService;
import com.example.multimodule.questionlib.api.AnswerControllerApi;
import com.example.multimodule.questionlib.api.QuestionControllerApi;
import com.example.multimodule.userlib.api.UserControllerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class UserQuestionService extends AbstractCrudService<UserQuestion> {
    private final UserQuestionRepository userQuestionRepository;

    private final QuestionControllerApi questionApi;

    private final UserControllerApi usersApi;

    private final AnswerControllerApi answerApi;

    Logger logger = LoggerFactory.getLogger(UserQuestionService.class);

    public UserQuestionService(
            @Autowired UserQuestionRepository userDisplayRepo,
            @Autowired QuestionControllerApi questionApi,
            @Autowired AnswerControllerApi answerApi,
            @Autowired UserControllerApi usersApi
    ) {
        super(userDisplayRepo, UserChoiceConstants.URI);
        this.userQuestionRepository = userDisplayRepo;
        this.questionApi = questionApi;
        this.usersApi = usersApi;
        this.answerApi = answerApi;
    }

    public String doAnswerToQuestion(
            final long questionId,
            final Boolean choice,
            final long userId
    ) throws Exception {

        String response = "Erreur pour trouver l'utilisateur";

        final var userRes = usersApi.find(userId);

        if (Objects.requireNonNull(userRes).getId() != userId) return response;

        response = "Erreur pour trouver la question";

        final var question= questionApi.find1(questionId);

        if (Objects.requireNonNull(question).getId() != questionId) return response;

        UserQuestion userQuestion = new UserQuestion();

        List<UserQuestion> answered = findAllUserChoicesForQuestion(userId, question.getId());

        userQuestion.setUser(userId);
        userQuestion.setQuestion(question.getId());
        userQuestion.setTries(userQuestion.getTries() + 1);

        userQuestion.setCurrentPoints(answerApi.findByQuestion(question.getId()).isCorrectAnswer() == choice
                ? 5 - answered.size()
                : 0
        );

        userQuestionRepository.save(userQuestion);

        return responseFromPoints((int) userQuestion.getCurrentPoints());
    }

    protected List<UserQuestion> findAllUserChoicesForQuestion(long user, long question) {
        return userQuestionRepository.findAllUserChoicesForQuestion(user, question);
    }

    /**
     * Get response from point.
     *
     * @param point point
     * @return (String)
     */
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:MagicNumber"})
    protected String responseFromPoints(Integer point) {
        return new HashMap<Integer, String>() {{
            put(0, "Réponse incorrecte");
            put(5, "Réponse correcte");
        }}.get(point);
    }
}
