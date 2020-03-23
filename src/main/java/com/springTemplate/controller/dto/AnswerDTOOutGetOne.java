package com.springTemplate.controller.dto;

import com.springTemplate.model.Answer;
import com.springTemplate.model.Topic;
import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AnswerDTOOutGetOne {

    private Long id;
    private String message;
    private String topic;
    private LocalDateTime date;

    public AnswerDTOOutGetOne(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.topic = answer.getTopic().getTitle();
        this.date = answer.getDateCreated();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
