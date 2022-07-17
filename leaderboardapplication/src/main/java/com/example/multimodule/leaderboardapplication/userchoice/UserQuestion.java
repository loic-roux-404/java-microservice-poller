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
public class UserQuestion implements IdentifiedEntity {

    /**
     * The id.
     */
    @GeneratedValue(generator = "seq_gen_userQuestion")
    @GenericGenerator(name = "seq_gen_userQuestion",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "seq_answerQuestion"),
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
     * The points.
     */
    private long currentPoints;

    /**
     * tries
     */
    private long tries;
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


    public long getTries() {
        return tries;
    }

    public void setTries(long tries) {
        this.tries = tries;
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
