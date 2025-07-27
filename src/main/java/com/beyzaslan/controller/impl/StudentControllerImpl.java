package com.beyzaslan.controller.impl;

import com.beyzaslan.controller.IStudentController;
import com.beyzaslan.entities.Student;
import com.beyzaslan.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/student")
public class StudentControllerImpl implements IStudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping(path = "/save")
    @Override
    public Student saveStudent( @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(path = "/list")
    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
