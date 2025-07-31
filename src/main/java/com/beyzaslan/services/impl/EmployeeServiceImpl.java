package com.beyzaslan.services.impl;

import com.beyzaslan.dto.DtoDepartment;
import com.beyzaslan.dto.DtoEmployee;
import com.beyzaslan.entities.Employee;
import com.beyzaslan.repository.EmployeeRepository;
import com.beyzaslan.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DtoEmployee> findAllEmployees() {
        List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
       List<Employee> employeeList = employeeRepository.findAll();
       if(employeeList!= null && !employeeList.isEmpty()){
           for(Employee employee : employeeList){
               DtoEmployee dtoEmployee = new DtoEmployee();
               BeanUtils.copyProperties(employee,dtoEmployee);
               dtoEmployee.setDtoDepartment((new DtoDepartment(employee.getDepartment().getId(),employee.getDepartment().getDepartmentName())));

               dtoEmployeeList.add(dtoEmployee);
           }
       }
       return dtoEmployeeList;

    }
}
