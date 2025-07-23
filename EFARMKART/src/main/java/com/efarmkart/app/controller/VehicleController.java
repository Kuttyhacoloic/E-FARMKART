package com.efarmkart.app.controller;

import java.lang.module.ResolutionException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.JpaRepositoryNameSpaceHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efarmkart.app.model.Vehicle;
import com.efarmkart.app.response.ApiResponse;
import com.efarmkart.app.service.VehicleService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/api/Vehicle")
public class VehicleController{

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	
	public ResponseEntity<ApiResponse<Vehicle>> createVehicle(@RequestBody Vehicle vehicle){
		
		Vehicle v = vehicleService.createVechicle(vehicle);
		ApiResponse <Vehicle> response = new ApiResponse<Vehicle>("vechical created sucessfully", v , true);
		return ResponseEntity.ok(response);
		
	}
	
	
	@GetMapping("/{id}")
	
	public ResponseEntity<ApiResponse<Vehicle>> getVehicleById(@PathVariable Long id){
	
		return vehicleService.getVehicleById(id).map((v)->{
			
			return ResponseEntity.ok(new ApiResponse<>("vechicle found", v , true));
		}).orElseThrow(()-> new ResolutionException("vechicle not found"));
	}
}
