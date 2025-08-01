package com.beyzaslan.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAddress {

    private Long id;
    private String description;
    private DtoCustomer customer;

}
