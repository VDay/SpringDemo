package com.review.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.review.entities.Employee;
import com.review.repositories.EmployeeRespository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRespository employeeRepository;
	@Transactional
	public List<Employee>getAllEmps(){
		return employeeRepository.findAll();
	}
	@Transactional
	public Employee getEmployById(Integer id){
		return employeeRepository.findOne(id);
	}
	@Transactional
	public void saveEmployee(Employee employee){
		employeeRepository.saveAndFlush(employee);
	}
	@Transactional
	public void delEmp(Integer id){
		employeeRepository.delete(id);
	}
	
	@Transactional
	public void addEmp(Employee employee){
		employee.setCreateTime(new Date());
		employeeRepository.saveAndFlush(employee);
	}
	@Transactional
	public Page<Employee> getPagedEmps(int pageNo, int pageSize){
		PageRequest page =new PageRequest(pageNo, pageSize);
		return employeeRepository.findAll(page);
	}
	
	

}
