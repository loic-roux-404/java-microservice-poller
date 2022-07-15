package com.example.multimodule.leaderboardapplication.useranswer;

import com.example.multimodule.service.IdentifiedEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * UserAnswer class.
 */
@Entity
public class UserAnswer implements IdentifiedEntity {

    /**
     * The id.
     */
    @GeneratedValue(generator = "seq_gen_userAnswer")
    @GenericGenerator(name = "seq_gen_userAnswer",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "seq_answerUser"),
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
     * The anwser.
     */
    private long answer;
    /**
     * The points.
     */
    private long points;

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
    public long getPoints() {
        return points;
    }

    /**
     * @param newPoints the points to set
     */
    public void setPoints(final long newPoints) {
        this.points = newPoints;
    }

    /**
     * @return the answer
     */
    public long getAnswer() {
        return answer;
    }

    /**
     * @param newAnswer the answer to set
     */
    public void setAnswer(final long newAnswer) {
        this.answer = newAnswer;
    }

}
