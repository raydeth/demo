package com.max.demo.entities.joined;

import com.max.demo.entities.UuidEntity;
import com.max.demo.entities.base.Course;
import com.max.demo.entities.base.Student;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "STUDENT_ENROLLMENTS")
public class StudentEnrollment extends UuidEntity {

    @JoinColumn(name = "COURSE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @JoinColumn(name = "STUDENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public static final class Builder {
        private Course course;
        private Student student;

        private Builder() {
        }

        public static Builder aStudentEnrollment() {
            return new Builder();
        }

        public Builder course(Course course) {
            this.course = course;
            return this;
        }

        public Builder student(Student student) {
            this.student = student;
            return this;
        }

        public StudentEnrollment build() {
            StudentEnrollment studentEnrollment = new StudentEnrollment();
            studentEnrollment.student = this.student;
            studentEnrollment.course = this.course;
            return studentEnrollment;
        }
    }
}