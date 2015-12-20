package com.review.component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.review.entities.Employee;

@Component(value="myConverter")
public class EmployeeConverter implements Converter<String , Employee>{

	@Override
	public Employee convert(String source) {
		System.out.println("------------------into Converter");
		String[] parts = source.split(",");
		Employee employee = new Employee();
		employee.setLastName(parts[0]);
		employee.setEmail(parts[1]);
		employee.setBirth(toDate(parts[2]));
		return employee;
	}
	
	private Date toDate(String str){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		try {
			date =sdf.parse(str);
		} catch (ParseException e) {
		}
		return date;
	}

}
