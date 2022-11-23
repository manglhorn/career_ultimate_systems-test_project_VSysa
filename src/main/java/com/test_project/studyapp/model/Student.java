package com.test_project.studyapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2)
    @Column(name = "studentName")
    private String studentName;

    @Column(name = "studentLastName")
    private String studentLastName;

    @Min(value = 18)
    @Column(name = "age")
    private String age;

    @Email()
    @Column(name = "email")
    private String email;

    @Column(name = "faculty")
    private String faculty;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "students")
    @JsonIgnore
    private Set<Teacher> teachers = new HashSet<>();

    public Student() {

    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
