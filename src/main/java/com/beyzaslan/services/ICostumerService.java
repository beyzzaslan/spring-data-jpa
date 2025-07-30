package com.beyzaslan.services;

import com.beyzaslan.dto.DtoAddress;
import com.beyzaslan.dto.DtoCustomer;

public interface ICostumerService {
    public DtoCustomer findCustomerById(Long id);

}
