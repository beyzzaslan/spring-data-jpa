package com.beyzaslan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")//veritabanına employee adında bir tablo açar
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    //birçok employeem var ama sadece tek bir departmentte çalışıcakklar

    @ManyToOne
    private Department department;

}
