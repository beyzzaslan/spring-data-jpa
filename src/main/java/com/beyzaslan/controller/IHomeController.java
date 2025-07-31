package com.beyzaslan.controller;

import com.beyzaslan.dto.DtoHome;

public interface IHomeController {
    public DtoHome findHomeById(Long id);
}
