package com.example.multimodule.leaderboardapplication;

import com.example.multimodule.questionlib.api.AnswerControllerApi;
import com.example.multimodule.questionlib.api.QuestionControllerApi;
import com.example.multimodule.userlib.api.UserControllerApi;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public UserControllerApi userControllerApi() {
        return new UserControllerApi();
    }

    @Bean
    public QuestionControllerApi questionControllerApi() {
        return new QuestionControllerApi();
    }

    @Bean
    public AnswerControllerApi answerControllerApi() {
        return new AnswerControllerApi();
    }
}
