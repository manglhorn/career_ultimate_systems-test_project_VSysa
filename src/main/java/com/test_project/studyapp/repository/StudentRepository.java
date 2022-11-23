package com.test_project.studyapp.repository;

import com.test_project.studyapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentsByTeachersId(Long teacherId);
}
