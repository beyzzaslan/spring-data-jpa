package com.beyzaslan.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
@Data//getter ve setter birleşimi bir yapı
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id//id yi veri tabanında primary key olarak belirt demek
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_Name", nullable = false)
    private String firstName;
    @Column(name = "last_Name", nullable = false)
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_Of_Date")
    private Date birthOfDate;

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}

