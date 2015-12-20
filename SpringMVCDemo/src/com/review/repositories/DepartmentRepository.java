package com.review.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.review.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
