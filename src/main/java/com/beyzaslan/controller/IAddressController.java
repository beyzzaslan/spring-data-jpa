package com.beyzaslan.controller;

import com.beyzaslan.dto.DtoAddress;

public interface IAddressController {
    public DtoAddress findAddressById(Long id);

}
