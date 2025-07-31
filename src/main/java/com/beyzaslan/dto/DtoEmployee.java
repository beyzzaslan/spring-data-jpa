package com.beyzaslan.dto;

import com.beyzaslan.entities.Department;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployee {
    private Long id;
    private String name;
    private DtoDepartment dtoDepartment;

}
