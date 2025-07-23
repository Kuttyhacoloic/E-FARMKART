package com.efarmkart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efarmkart.app.exception.ResourceNotFoundException;
import com.efarmkart.app.model.Procurement;
import com.efarmkart.app.response.ApiResponse;
import com.efarmkart.app.service.ProcurementService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@Data
@RequestMapping("/api/procurement")
@RequiredArgsConstructor
public class ProcurmentController {
	
	@Autowired
	private ProcurementService procurementService;
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<Procurement>>> getAllProcurment(){
		
		try {
			List<Procurement> procurment = procurementService.getAllProcurement();
			return ResponseEntity.ok(new ApiResponse<>("procurements found ", procurment, true));
			
		} 
		catch (Exception e) {
			List<Procurement> procurment = procurementService.getAllProcurement();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).
					body(new ApiResponse<>("procurements not found ", null, false));
		}
	}
	
	@PostMapping
	public ResponseEntity<Procurement> createprocurement(@RequestBody Procurement procurement){

			return ResponseEntity.ok(procurementService.createProcurement(procurement));
	}
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Procurement>> getprocurmentById(@PathVariable Long id){
		
		return procurementService.getProcurementById(id).map((pr)-> {
			
			return ResponseEntity.ok(new ApiResponse<>("procurement found", pr, true));
		}).orElseThrow(()-> new ResourceNotFoundException("procurement note found"));
	}
}
