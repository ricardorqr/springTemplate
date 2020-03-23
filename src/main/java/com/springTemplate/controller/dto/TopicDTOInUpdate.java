package com.springTemplate.controller.dto;

import com.springTemplate.model.Topic;
import com.springTemplate.repository.TopicRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicDTOInUpdate {

    @NotEmpty
    @NotNull
    @Length(min = 5, max = 200)
    private String title;
    @NotEmpty
    @NotNull
    @Length(min = 5, max = 200)
    private String message;

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

    public Topic update(Long id, TopicRepository topicRepository) {
        Topic topic = topicRepository.getOne(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }
}
