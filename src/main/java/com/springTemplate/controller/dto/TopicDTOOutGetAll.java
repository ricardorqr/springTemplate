package com.springTemplate.controller.dto;

import com.springTemplate.model.Topic;
import com.springTemplate.model.TopicStatus;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<TopicDTOOutGetAll> getTopicDTOOut(List<Topic> topics) {
        return topics.stream().map(TopicDTOOutGetAll::new).collect(Collectors.toList());
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
