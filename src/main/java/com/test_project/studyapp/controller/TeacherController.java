package com.test_project.studyapp.controller;

import com.test_project.studyapp.model.Teacher;
import com.test_project.studyapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers(@RequestParam(required = false) String teacherLastName) {
        List<Teacher> teachers = new ArrayList<Teacher>();

        if (teacherLastName == null) {
            teachers.addAll(teacherRepository.findAll());
        }
        if (teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
}
