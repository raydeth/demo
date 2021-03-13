package com.max.demo.controllers;

import com.max.demo.entities.base.Course;
import com.max.demo.entities.base.Student;
import com.max.demo.entities.joined.StudentEnrollment;
import com.max.demo.repositories.CourseRepository;
import com.max.demo.repositories.StudentEnrollmentRepository;
import com.max.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student-enrollment")
public class StudentEnrollmentController {

    @Autowired
    private StudentEnrollmentRepository studentEnrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public void enrollStudentToCourse(@RequestParam UUID studentId,
                                      @RequestParam UUID courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NullPointerException(String.format("Can not find student by ID [%s]", studentId)));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NullPointerException(String.format("Can not find course by ID [%s]", courseId)));

        studentEnrollmentRepository.save(StudentEnrollment.Builder.aStudentEnrollment()
                .course(course)
                .student(student)
                .build());
    }
}
