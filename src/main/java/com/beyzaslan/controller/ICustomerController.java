package com.beyzaslan.controller;

import com.beyzaslan.dto.DtoCustomer;

public interface ICustomerController {
    public DtoCustomer findCustomerById(Long id);
}