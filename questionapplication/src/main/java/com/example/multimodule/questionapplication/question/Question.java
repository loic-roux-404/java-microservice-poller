package com.example.multimodule.questionapplication.question;

import com.example.multimodule.service.IdentifiedEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Question class.
 */
@Entity
public class Question implements IdentifiedEntity {
    /**
     * The id.
     */
    @GeneratedValue
    @Id
    private long id;
    /**
     * The content.
     */
    private String content;

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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param newContent the content to set
     */
    public void setContent(final String newContent) {
        this.content = newContent;
    }

}
