package com.beyzaslan.controller;

import com.beyzaslan.dto.DtoStudent;
import com.beyzaslan.dto.DtoStudentIU;
import com.beyzaslan.entities.Student;

import java.util.List;

public interface IStudentController {
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);

}
