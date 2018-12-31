package com.example.demo.dao;

import java.util.Optional;

import com.example.demo.entity.Student;

public interface ExtendedStudentRepository extends ExtendedRepository<Student, Long> {
	Optional<Student> findByName(String name);
}
