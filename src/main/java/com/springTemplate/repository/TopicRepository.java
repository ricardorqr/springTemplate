package com.springTemplate.repository;

import com.springTemplate.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    public List<Topic> findByCourseName(String name);

    @Query(value = "SELECT t FROM Topic t WHERE t.course.name = :name")
    public List<Topic> findByCourseNameOptional(@Param(value = "name") String name);

}
