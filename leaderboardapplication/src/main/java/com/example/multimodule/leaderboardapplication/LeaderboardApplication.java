package com.example.multimodule.leaderboardapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.multimodule.questionlib.api")
public class LeaderboardApplication {

	public LeaderboardApplication() {}

	public static void main(String[] args) {
		SpringApplication.run(LeaderboardApplication.class, args);
	}
}
