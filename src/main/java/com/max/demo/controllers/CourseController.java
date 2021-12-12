package com.max.demo.controllers;

import com.max.demo.entities.base.Course;
import com.max.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/{id}")
    public Course course(@PathVariable UUID id) {
        return  courseRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Can not find course by ID [%s]", id)));
    }

    @DeleteMapping("/{id}")
    public  void deleteCourse(@PathVariable UUID id) {

        Course  course = courseRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format(" Can not find course by ID [%s] ", id)));
        courseRepository.delete(course);
    }

    @GetMapping("/all")
    public List<Course> course() {
        return
            courseRepository.findAll();

    }

    @PostMapping
    public void createNewCourse(String name) {

        courseRepository.save(Course.Builder.course()
                .name(name)
                .build());
    }
}
