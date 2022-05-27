package com.example.student.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudnetRepo extends JpaRepository<Student , Long> {


    List<Student> findAllByUsername(String name);
}
