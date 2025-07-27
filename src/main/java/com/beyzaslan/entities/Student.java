package com.beyzaslan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data//getter ve setter birleşimi bir yapı
@NoArgsConstructor
@AllArgsConstructor
public class Student
{
    @Id//id yi veri tabanında primary key olarak belirt demek
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_Name",nullable = false)
    private String firstName;
    @Column(name = "last_Name",nullable = false)
    private String lastName;
    @Column(name = "birth_Of_Date")
    private String birthOfDate;
}

