package com.springTemplate.controller.dto;

import com.springTemplate.model.Topic;

import java.time.LocalDateTime;

public class TopicDTOOutAdd {

    private Long id;
    private String message;
    private String title;
    private LocalDateTime dateCreated;

    public TopicDTOOutAdd(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateCreated = topic.getDateCreated();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
