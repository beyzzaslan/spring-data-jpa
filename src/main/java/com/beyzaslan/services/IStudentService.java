package com.beyzaslan.services;

import com.beyzaslan.entities.Student;

import java.util.List;

public interface IStudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

}
