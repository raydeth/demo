package com.max.demo.entities.base;

import com.max.demo.entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES")
public class Course extends BaseEntity {
    public static final class Builder {
        private String name;

        private Builder() {
        }

        public static Builder course() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Course build() {
            Course course = new Course();
            course.setName(name);
            return course;
        }
    }
}
