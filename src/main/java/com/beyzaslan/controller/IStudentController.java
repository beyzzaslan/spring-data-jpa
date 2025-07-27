package com.beyzaslan.controller;

import com.beyzaslan.entities.Student;

import java.util.List;

public interface IStudentController {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();

}
