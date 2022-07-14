package fr.gamedev.leaderboard.useranswer;

import fr.gamedev.question.answer.Answer;
import fr.gamedev.core.restcommons.IdentifiedEntity;
import fr.gamedev.question.user.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    @ManyToOne
    private Answer answer;
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
    public Answer getAnswer() {
        return answer;
    }

    /**
     * @param newAnswer the answer to set
     */
    public void setAnswer(final Answer newAnswer) {
        this.answer = newAnswer;
    }

}
