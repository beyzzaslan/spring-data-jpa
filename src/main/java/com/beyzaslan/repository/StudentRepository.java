package com.beyzaslan.repository;

import com.beyzaslan.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    /*

     * HQL: sınıf ismi ve değişken isimleri ile sorgular yazılır
     * SQL: tablo ismi ve tablodaki kolon isimleri ile sorgı yazılır

     */
    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudent();

    @Query(value = "from Student s WHERE s.id = :studentId")
    Optional<Student> findStudentById(Integer studentId);
}
