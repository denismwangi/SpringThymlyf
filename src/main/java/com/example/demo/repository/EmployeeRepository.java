package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Employees;
import com.example.demo.models.User;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
	
	
	
	//Optional<Employees> findByEmail(String email);

}
