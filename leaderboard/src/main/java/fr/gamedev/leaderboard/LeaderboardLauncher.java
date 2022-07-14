package fr.gamedev.leaderboard;

import fr.gamedev.question.QuestionLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author djer1
 *
 */
@SuppressWarnings({ "checkstyle:HideUtilityClassConstructor" })
@SpringBootApplication(scanBasePackages = "fr.baeldung")
public class LeaderboardLauncher {

    /**
     * @param args command line params
     */
    public static void main(final String[] args) {
        SpringApplication.run(QuestionLauncher.class, args);
    }

}
