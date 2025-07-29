package com.beyzaslan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {//insert update işlemlerinde kullanılır

    private String firstName;
    private String lastName;
    private Date birthOfDate;
}
