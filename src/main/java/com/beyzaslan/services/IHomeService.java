package com.beyzaslan.services;

import com.beyzaslan.dto.DtoHome;

public interface IHomeService {
    public DtoHome findHomeById(Long id);

}
