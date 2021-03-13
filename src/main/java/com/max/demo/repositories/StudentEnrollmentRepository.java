package com.max.demo.repositories;

import com.max.demo.entities.joined.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, UUID> {
}
