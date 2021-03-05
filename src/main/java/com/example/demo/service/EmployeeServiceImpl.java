package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employees;
import com.example.demo.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		
		return employeeRepository.findAll();
		
	}
	
	@Override
	public void saveEmployee(Employees employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employees getEmployeeByd(Long id) {
		// TODO Auto-generated method stub
		Optional<Employees> optional = employeeRepository.findById(id);
		Employees employee = null;
		if(optional.isPresent()) {
			employee= optional.get();
		}else {
			throw new RuntimeException("employee not found with id:" +id);
		}
		return employee;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		
		this.employeeRepository.deleteById(id);
		
	}

}
