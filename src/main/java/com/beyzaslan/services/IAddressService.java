package com.beyzaslan.services;

import com.beyzaslan.dto.DtoAddress;

public interface IAddressService {
    public DtoAddress findAddressById(Long id);

}
