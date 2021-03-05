package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Employees;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String ViewEmployee(Model model) {
		
		model.addAttribute("listEmployees", employeeService.getAllEmployees() );
		
		return "employees/employees";
		
	}
	
	@GetMapping("/newemployee")
	public String NewEmployee(Model model) {
		
		//create model attribute to bind data
		Employees employee = new Employees();
		
		model.addAttribute("employee", employee);
		
		return "employees/add_new";
	}
	
	@PostMapping("/saveemployee")
	public String Saveemployee(@ModelAttribute("employee") Employees employee) {
		
		//save to the db
		employeeService.saveEmployee(employee);
		
		
		
		return "redirect:/employees";
	}
	
	 @GetMapping("/update_employee/{id}")
	public String Updateemployee(@PathVariable (value = "id") Long id , Model model) {
		 
		 
		 //get employee from the service
		 Employees employee = employeeService.getEmployeeByd(id);
		 
		 //set employee as the model i.e repopulate the form
		 model.addAttribute("employee", employee);
		 
		 
		 
		
		return "employees/update_employee";
	}
	 
	 @GetMapping("/delete_employee/{id}")
	 public String DeleteEmployee(@PathVariable (value = "id") Long id , Model model) {
		 
		this.employeeService.deleteEmployee(id);
		 
		return "redirect:/employees";
		 
		 
		 
	 }
}
	

	
	

















	
	

