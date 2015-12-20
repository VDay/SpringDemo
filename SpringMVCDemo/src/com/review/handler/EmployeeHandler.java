package com.review.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.review.entities.Department;
import com.review.entities.Employee;
import com.review.service.DepartmentSerivce;
import com.review.service.EmployeeService;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentSerivce departmentService;

	@RequestMapping(value="/empList")
	public String getAllEmps(Map<String, Object> map) {
		List<Employee> employees = employeeService.getAllEmps();
		map.put("employees", employees);
		return "empList";
	}
	
	@RequestMapping(value="/toEdit/{id}", method=RequestMethod.GET)
	public String toEditPage(@PathVariable(value="id")Integer id,Map<String , Object>map){
		Employee employee = employeeService.getEmployById(id);
		List<Department>departments =departmentService.getAllDepts();
		map.put("departments", departments);
		map.put("employee", employee);
		return "edit";
	}
	@RequestMapping(value="/edit", method=RequestMethod.PUT)
	public String edit(Employee employee ){
		employeeService.saveEmployee(employee);
		return "redirect:empList";
	}
	
	@RequestMapping(value="/delete/{id}" , method=RequestMethod.DELETE)
	public String delete(@PathVariable("id")Integer id){
		employeeService.delEmp(id);
		return "redirect:empList";
	}
	@ModelAttribute
	public void getModel(@RequestParam(value="id", required=false)Integer id,Map<String , Object>map){
		if(id!=null){
			Employee employee = employeeService.getEmployById(id);
			employee.setDepartment(null);
			map.put("employee", employee);
		}
	}
	@RequestMapping(value="/toAddPage", method=RequestMethod.GET)
	public String toAddPage(Employee employee,Map<String ,Object>map){
		List<Department>departments =departmentService.getAllDepts();
		map.put("departments", departments);
		return "add";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addEmp(Employee employee ){
		employeeService.addEmp(employee);
		return "redirect:empList";
	}
	
	@RequestMapping(value="/pagedEmps", method=RequestMethod.GET)
	public String emps(@RequestParam(value="pageNo",required=false)Integer pageNo,Map <String ,Object>map){
		Page pagedEmp = employeeService.getPagedEmps(pageNo, 3);
		map.put("pagedEmp", pagedEmp);
		return "empList";
	}
	
	@RequestMapping(value="/addNewEmployee", method=RequestMethod.POST)
	public String addStrEmp(@RequestParam(value=" employee",required=false) Employee employee){
		System.out.println(employee);
		employeeService.addEmp(employee);
		return "empList";
	}
	
}
