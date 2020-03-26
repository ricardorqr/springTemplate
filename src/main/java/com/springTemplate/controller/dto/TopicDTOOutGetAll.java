package com.springTemplate.controller.dto;

import com.springTemplate.model.Topic;
import com.springTemplate.model.TopicStatus;
import org.springframework.data.domain.Page;

public class TopicDTOOutGetAll {

    private Long id;
    private String message;
    private String title;
    private TopicStatus status;

    public TopicDTOOutGetAll(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.status = topic.getStatus();
    }

    public static Page<TopicDTOOutGetAll> getTopicDTOOut(Page<Topic> topics) {
        return topics.map(TopicDTOOutGetAll::new);
    }

    public Long getId() {
        return id;
    }

    public TopicStatus getStatus() { return status; }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

}
