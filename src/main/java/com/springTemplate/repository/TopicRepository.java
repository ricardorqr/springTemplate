package com.springTemplate.repository;

import com.springTemplate.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    public Page<Topic> findByCourseName(String name, Pageable pageable);

    @Query(value = "SELECT t FROM Topic t WHERE t.course.name = :name")
    public List<Topic> findByCourseNameOptional(@Param(value = "name") String name);

}
