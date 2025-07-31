package com.beyzaslan.services;

import com.beyzaslan.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeService {
    //bütün employeeleri çekecek bşr servis yazalım
    public List<DtoEmployee> findAllEmployees();
}
