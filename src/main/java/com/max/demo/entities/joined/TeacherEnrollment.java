package com.max.demo.entities.joined;

import com.max.demo.entities.UuidEntity;
import com.max.demo.entities.base.Course;
import com.max.demo.entities.base.Teacher;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TEACHER_ENROLLMENTS")
public class TeacherEnrollment extends UuidEntity {

    @JoinColumn(name = "TEACHER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacherId;

    @JoinColumn(name = "COURSE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Course courseId;

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }
}
