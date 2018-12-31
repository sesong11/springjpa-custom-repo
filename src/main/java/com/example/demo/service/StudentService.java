package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Student;

public interface StudentService {
	Optional<Student> findById(Long id);
	Optional<Student> findByName(String name);
}
