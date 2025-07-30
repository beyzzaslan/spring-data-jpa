package com.beyzaslan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id sini otomatik olarak versin diye bu satırı yazıyoruz
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne//müşterinin 1 tane adresi olabilir
    private Address address;
}
//adress sınıfıyla çift taraflı ilişki yapmak isriyorsak address classına customerı tanımla
