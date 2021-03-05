package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Employees;

public interface EmployeeService {
	
	 

	List<Employees> getAllEmployees();
	void saveEmployee(Employees employee);
	Employees getEmployeeByd(Long id);
	void deleteEmployee(Long id);

	

}
