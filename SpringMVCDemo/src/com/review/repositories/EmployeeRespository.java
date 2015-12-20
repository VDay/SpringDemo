package com.review.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.review.entities.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer>{

}
