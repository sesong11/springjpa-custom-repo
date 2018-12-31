package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ExtendedStudentRepository;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private ExtendedStudentRepository dao;
	@Override
	public Optional<Student> findById(final Long id) {
		return dao.findById(id);
	}
	@Override
	public Optional<Student> findByName(String name) {
		return dao.findByName(name);
	}

}
