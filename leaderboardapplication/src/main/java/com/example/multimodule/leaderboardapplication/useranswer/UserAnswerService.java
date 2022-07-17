package com.example.multimodule.leaderboardapplication.useranswer;

import com.example.multimodule.questionlib.api.AnswerApiDelegate;
import com.example.multimodule.questionlib.api.QuestionApiDelegate;
import com.example.multimodule.questionlib.model.Answer;
import com.example.multimodule.service.AbstractCrudService;
import com.example.multimodule.userlib.api.UsersApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserAnswerService extends AbstractCrudService<UserAnswer> {
    UserAnswerRepository userAnswerRepository;

    AnswerApiDelegate answerApi;

    QuestionApiDelegate questionApi;

    UsersApi usersApi;

    public UserAnswerService(
            @Autowired UserAnswerRepository userDisplayRepo,
            @Autowired AnswerApiDelegate answerApi,
            @Autowired QuestionApiDelegate questionApi,
            @Autowired UsersApi usersApi
    ) {
        super(userDisplayRepo, UserAnswerConstants.URI);
        this.answerApi = answerApi;
        this.questionApi = questionApi;
        this.usersApi = usersApi;
    }

    public String doAnswerToQuestion(
            final long questionId,
            final Boolean answer,
            final long userId
    ) {

        String response = "Erreur pour trouver l'utilisateur";

        final var questionEn = questionApi.get1(questionId);

        if (!questionEn.hasBody()) return response;

        final var questionFetchedId = Objects.requireNonNull(questionEn.getBody()).getId();
        final var expectedAnswerRes = answerApi.get3(questionId);
        response = "Erreur pour trouver la question";

        if (!expectedAnswerRes.hasBody()) return response;

        final var expectedAnswer= Objects.requireNonNull(expectedAnswerRes.getBody());

        UserAnswer userAnswer = new UserAnswer();

        // TODO find user over api
        final var userRes = usersApi.exists(userId);

        if (!userRes.hasBody() && Boolean.FALSE.equals(userRes.getBody())) return response;

        List<UserAnswer> anwsered = getAlreadyAnsweredCorrect(userId, questionFetchedId);

        userAnswer.setUser(userId);
        userAnswer.setAnswer(expectedAnswer.getId());

        userAnswer.setPoints(expectedAnswer.getCorrectAnswer() == answer
                ? 5 - anwsered.size()
                : 0
        );

        userAnswerRepository.save(userAnswer);

        return responseFromPoints((int) userAnswer.getPoints());
    }

    public List<UserAnswer> getAlreadyAnsweredCorrect(long user, long question) {
        final var userAnwsers = userAnswerRepository.findByUserCorrect(user);

        final var answers = answerApi.findAllByQuestion(question).getBody();

        if (answers == null) return userAnwsers;

        return userAnwsers.stream()
                .filter(Objects::nonNull)
                .filter(e -> answers.stream()
                        .map(Answer::getId)
                        .collect(Collectors.toList())
                        .contains(e.getAnswer())
                )
                .collect(Collectors.toList());
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
