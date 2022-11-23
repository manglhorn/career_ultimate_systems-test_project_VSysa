package com.test_project.studyapp.repository;

import com.test_project.studyapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findTeachersByStudentsId(Long studentId);
}
