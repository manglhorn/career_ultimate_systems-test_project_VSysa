package com.test_project.studyapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2)
    @Column(name = "teacherName")
    private String teacherName;

    @Column(name = "teacherLlastName")
    private String teacherLastName;

    @Min(value = 18)
    @Column(name = "age")
    private String age;

    @Email()
    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private String subject;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "teacher_students",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<Student> students = new HashSet<>();

    public Teacher() {

    }

    public Teacher(Long id, String teacherName, String teacherLastName, String age, String email, String subject, Set<Student> students) {
        this.id = id;
        this.teacherName = teacherName;
        this.teacherLastName = teacherLastName;
        this.age = age;
        this.email = email;
        this.subject = subject;
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.getTeachers().add(this);
    }

    public void removeStudent(long studentId) {
        Student student = this.students.stream()
                .filter(t -> t.getId() == studentId)
                .findFirst()
                .orElse(null);

        if (student != null) {
            this.students.remove(student);
            student.getTeachers().remove(this);
        }
    }
}
