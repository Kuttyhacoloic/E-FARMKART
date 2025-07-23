package com.efarmkart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.Employee;
import com.efarmkart.app.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeerepo;
	
	public List<Employee> getAllEmployee() {
		return employeerepo.findAll();
	}
	
	public Employee createEmployee(Employee employee) {
		return employeerepo.save(employee);
	}
	
	public Optional<Employee> getEmployeeById(Long id) {
		return employeerepo.findById(id);
		
	}
	
	public Optional<Employee> deleteEmployeeById(Long id) {
		
	    Optional<Employee> emp = employeerepo.findById(id);
	    emp.ifPresent(e -> employeerepo.deleteById(id));
	    return emp;
	}
}
