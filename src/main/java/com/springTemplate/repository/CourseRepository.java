package com.springTemplate.repository;

import com.springTemplate.model.Course;
import com.springTemplate.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    public Course findByName(String name);
}
