package com.beyzaslan.dto;

import jakarta.validation.constraints.*;
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
    @NotEmpty(message = "FirsName alanı boş bırakılamaz...")
    @NotNull(message = "FirstName alanı null olamaz...")
    @Min(3)//firstname kısmı minimum 3 karakterli olabilir
    @Max(10)
    private String firstName;
    @Size(min = 3, max = 30)

    private String lastName;

    private Date birthOfDate;

    @Email(message = "email formatında bir mesaj giriniz...")
    private String email;

    @Size(min = 11, max = 11, message = "Tckn alanı 11 karakter olmalıdır" )
    @NotEmpty(message = "Tckn alanı boş bırakılamaz...")
    private String tckn;
}
