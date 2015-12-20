package com.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.review.entities.Department;
import com.review.repositories.DepartmentRepository;

@Service
public class DepartmentSerivce {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Transactional
	public List<Department> getAllDepts() {
		return departmentRepository.findAll();
	}
}
