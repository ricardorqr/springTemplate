package com.springTemplate.controller.dto;

import com.springTemplate.model.*;

import java.time.LocalDateTime;

public class TopicDTOOutUpdate {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime date = LocalDateTime.now();
    private TopicStatus status;
    private String user;
    private String course;

    public TopicDTOOutUpdate(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.date = topic.getDateCreated();
        this.status = topic.getStatus();
        this.user = topic.getUser().getName();
        this.course = topic.getCourse().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TopicStatus getStatus() {
        return status;
    }

    public void setStatus(TopicStatus status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
