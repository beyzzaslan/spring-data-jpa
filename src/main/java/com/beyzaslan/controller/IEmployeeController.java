package com.beyzaslan.controller;

import com.beyzaslan.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeController {
    public List<DtoEmployee> findAllEmployees();
}
