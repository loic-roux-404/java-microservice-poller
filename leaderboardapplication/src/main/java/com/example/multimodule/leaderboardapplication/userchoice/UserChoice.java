package com.example.multimodule.leaderboardapplication.userchoice;

import com.example.multimodule.library.IdentifiedEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * UserAnswer class.
 */
@Entity
public class UserChoice implements IdentifiedEntity {

    /**
     * The id.
     */
    @GeneratedValue(generator = "seq_gen_userChoice")
    @GenericGenerator(name = "seq_gen_userChoice",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "seq_answerChoice"),
                    @Parameter(name = "initial_value", value = "0"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    private long id;

    /**
     * The User.
     */
    private long user;
    /**
     * The question user answered to.
     */
    private long question;

    /**
     * TODO: create a leader board table instead
     * The points.
     */
    private long currentPoints;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param newId the id to set
     */
    public void setId(final long newId) {
        this.id = newId;
    }

    /**
     * @return the user
     */
    public long getUser() {
        return user;
    }

    /**
     * @param newUser the user to set
     */
    public void setUser(final long newUser) {
        this.user = newUser;
    }

    /**
     * @return the points
     */
    public long getCurrentPoints() {
        return currentPoints;
    }

    /**
     * @param newPoints the points to set
     */
    public void setCurrentPoints(final long newPoints) {
        this.currentPoints = newPoints;
    }

    /**
     * @return the answer
     */
    public long getQuestion() {
        return question;
    }

    /**
     * @param newAnswer the answer to set
     */
    public void setQuestion(final long newAnswer) {
        this.question = newAnswer;
    }
}
