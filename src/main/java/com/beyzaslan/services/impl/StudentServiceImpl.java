package com.beyzaslan.services.impl;

import com.beyzaslan.dto.DtoCourse;
import com.beyzaslan.dto.DtoStudent;
import com.beyzaslan.dto.DtoStudentIU;
import com.beyzaslan.entities.Course;
import com.beyzaslan.entities.Student;
import com.beyzaslan.repository.StudentRepository;
import com.beyzaslan.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);

        return response;
    }


    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudent();//bütün bilgilerle öğrencileri getirir
        for (Student student : studentList) {
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student, dto);
            dtoList.add(dto);
        }
        return dtoList;//repository kısmına bağlanıp listeyi çektik
    }

    @Override
    public DtoStudent getStudentById(Integer id) {//id ile öğrenci bulur

        DtoStudent dtoStudent = new DtoStudent();
        Optional<Student> optional = studentRepository.findStudentById(id);
        if(optional.isEmpty()){
            return  null;
        }
        Student dbStudent = optional.get();
        BeanUtils.copyProperties(dbStudent, dtoStudent);

        if(dbStudent.getCourses()!=null && !dbStudent.getCourses().isEmpty()){
            for(Course course : dbStudent.getCourses()){
                DtoCourse dtoCourse = new DtoCourse();
                BeanUtils.copyProperties(course,dtoCourse);

                dtoStudent.getCourses().add(dtoCourse);

            }
        }
        return dtoStudent;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            studentRepository.delete(optional.get());
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        DtoStudent dto = new DtoStudent();

        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Student dbStudent = optional.get();
            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent, dto);
            return dto;

        }
        return null;
    }
}
