package com.springTemplate.controller.dto;

import com.springTemplate.model.Topic;
import com.springTemplate.model.TopicStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDTOOutGetOne {

    private Long id;
    private String message;
    private String author;
    private LocalDateTime date;
    private TopicStatus status;
    private List<AnswerDTOOutGetOne> answers;

    public TopicDTOOutGetOne(Topic topic) {
        this.id = topic.getId();
        this.message = topic.getMessage();
        this.author = topic.getUser().getName();
        this.date = topic.getDateCreated();
        this.status = topic.getStatus();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getAnswers().stream().map(AnswerDTOOutGetOne::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TopicStatus getStatus() {
        return status;
    }

    public List<AnswerDTOOutGetOne> getAnswers() {
        return answers;
    }

}
