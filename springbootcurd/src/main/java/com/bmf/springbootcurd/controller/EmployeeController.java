package com.bmf.springbootcurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmf.springbootcurd.dao.EmployeeDAO;
import com.bmf.springbootcurd.model.Employee;
import com.bmf.springbootcurd.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
    private	EmployeeService employeeService;
	

	
    @GetMapping("/employee")
	public List<Employee> get(){
    	return employeeService.get();
    	
    }
    
    @GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		return employeeService.get(id);
	}
    
    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable int id) {
    	 employeeService.delete(id);
    	 return "Deleted with id :"+id;
    }
    
    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employeeObj) {
    	employeeService.save(employeeObj);
    	return employeeObj;
    	
    }
} 
