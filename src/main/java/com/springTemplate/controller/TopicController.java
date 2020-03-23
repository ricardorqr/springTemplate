package com.springTemplate.controller;

import com.springTemplate.controller.dto.*;
import com.springTemplate.model.Topic;
import com.springTemplate.repository.CourseRepository;
import com.springTemplate.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicDTOOutGetAll> getAll(String courseName) {
        if (courseName == null) {
            return TopicDTOOutGetAll.getTopicDTOOut(topicRepository.findAll());
        } else {
            return TopicDTOOutGetAll.getTopicDTOOut(topicRepository.findByCourseName(courseName));
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDTOOutAdd> add(@RequestBody @Valid TopicDTOInAdd topicIn, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicIn.getTopic(courseRepository);
        topicRepository.save(topic);

        URI uri = uriComponentsBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDTOOutAdd(topic));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TopicDTOOutGetOne> getOne(@PathVariable(value = "id") Long id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            return ResponseEntity.ok(new TopicDTOOutGetOne(topicOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<TopicDTOOutUpdate> update(@PathVariable(value = "id") Long id, @RequestBody @Valid TopicDTOInUpdate topicIn) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            Topic topic = topicIn.update(id, topicRepository);
            return ResponseEntity.ok(new TopicDTOOutUpdate(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}