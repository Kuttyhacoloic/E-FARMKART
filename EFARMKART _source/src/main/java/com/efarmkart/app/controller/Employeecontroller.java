package com.efarmkart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efarmkart.app.exception.ResourceNotFoundException;
import com.efarmkart.app.model.Employee;
import com.efarmkart.app.model.Farmer;
import com.efarmkart.app.repository.EmployeeRepo;
import com.efarmkart.app.response.ApiResponse;
import com.efarmkart.app.service.EmployeeService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
@Data
public class Employeecontroller {
	
	@Autowired
	private EmployeeService empolyeeService;
	private EmployeeRepo employeerepo;
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployee(){
		
		try {
			List<Employee> employees = empolyeeService.getAllEmployee();
            return ResponseEntity.ok(new ApiResponse<>("employee found", employees, true));		
		}
		
		catch (Exception e) {
			List<Employee> employees = empolyeeService.getAllEmployee();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("employee not found", null, false));		
		}
	}
	

	@PostMapping
	public ResponseEntity<ApiResponse<Employee>> createEmployee(@RequestBody Employee employee){
		
		Employee createEmployee = empolyeeService.createEmployee(employee);
		ApiResponse<Employee> response = new ApiResponse<Employee>
		("Employee created sucussfully", createEmployee, true);
				
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable Long id){
		
	
		return	empolyeeService.getEmployeeById(id).map((emp)->{
			
			return ResponseEntity.ok(new ApiResponse<>("employee found", emp, true));
		}).orElseThrow(()->  new ResourceNotFoundException("Employee not found"));
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Long id){
		
		empolyeeService.deleteEmployeeById(id);
		return ResponseEntity.noContent().build();
		
	}
}

