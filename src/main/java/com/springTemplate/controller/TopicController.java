package com.springTemplate.controller;

import com.springTemplate.controller.dto.*;
import com.springTemplate.model.Topic;
import com.springTemplate.repository.CourseRepository;
import com.springTemplate.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    @Cacheable(value = "getAllTopics")
    public Page<TopicDTOOutGetAll> getAll(@RequestParam(required = false) String courseName,
                                          @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable) {
        if (courseName == null) {
            Page<Topic> topics = topicRepository.findAll(pageable);
            return TopicDTOOutGetAll.getTopicDTOOut(topics);
        } else {
            Page<Topic> topics = topicRepository.findByCourseName(courseName, pageable);
            return TopicDTOOutGetAll.getTopicDTOOut(topics);
        }
    }

    @GetMapping(value = "/paginationOld")
    public Page<TopicDTOOutGetAll> getAllOld(@RequestParam(required = false) String courseName,
                                             @RequestParam int page,
                                             @RequestParam int size,
                                             @RequestParam String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sort);

        if (courseName == null) {
            Page<Topic> topics = topicRepository.findAll(pageable);
            return TopicDTOOutGetAll.getTopicDTOOut(topics);
        } else {
            Page<Topic> topics = topicRepository.findByCourseName(courseName, pageable);
            return TopicDTOOutGetAll.getTopicDTOOut(topics);
        }
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "getAllTopics", allEntries = true)
    public ResponseEntity<TopicDTOOutAdd> add(@RequestBody @Valid TopicDTOInAdd topicIn,
                                              UriComponentsBuilder uriComponentsBuilder) {
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
    @CacheEvict(value = "getAllTopics", allEntries = true)
    public ResponseEntity<TopicDTOOutUpdate> update(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid TopicDTOInUpdate topicIn) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            Topic topic = topicIn.update(id, topicRepository);
            return ResponseEntity.ok(new TopicDTOOutUpdate(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    @CacheEvict(value = "getAllTopics", allEntries = true)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}