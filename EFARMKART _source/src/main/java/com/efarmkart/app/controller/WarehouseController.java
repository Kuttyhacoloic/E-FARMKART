package com.efarmkart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efarmkart.app.exception.ResourceNotFoundException;
import com.efarmkart.app.model.Warehouse;
import com.efarmkart.app.response.ApiResponse;
import com.efarmkart.app.service.WarehouseService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/warehouse")
@Data
@RequiredArgsConstructor
public class WarehouseController {
	
	@Autowired
	private WarehouseService warehouseservice;
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<Warehouse>>> getAllEmployee(){
		
		try {
			List<Warehouse> warehouse = warehouseservice.getAllWarehouse();
			return ResponseEntity.ok(new ApiResponse<>("warehouse found ", warehouse, true));
			
		} catch (Exception e) {
			List<Warehouse> warehouse = warehouseservice.getAllWarehouse();
			return ResponseEntity.ok(new ApiResponse<>("warehouse not found", null, false));
		}
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<Warehouse>> CreateWarehouse(@RequestBody Warehouse warehouse){
		Warehouse wh = warehouseservice.CreateWarehouse(warehouse);
		ApiResponse<Warehouse> resonse = new ApiResponse<Warehouse>("Warehouse created ", wh, true);
		return ResponseEntity.ok(resonse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Warehouse>> getwarehouse(@PathVariable Long id){
		return warehouseservice.getWarehouseById(id).map((w)->{
			return ResponseEntity.ok(new ApiResponse<>("warehouse found", w , true));
		}).orElseThrow(()-> new ResourceNotFoundException("warehouse not found"));
	}
}
