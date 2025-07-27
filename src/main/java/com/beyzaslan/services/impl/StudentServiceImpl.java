package com.beyzaslan.services.impl;

import com.beyzaslan.entities.Student;
import com.beyzaslan.repository.StudentRepository;
import com.beyzaslan.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }
}
