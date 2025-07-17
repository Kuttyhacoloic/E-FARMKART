package com.efarmkart.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.Vehicle;
import com.efarmkart.app.repository.VehicleRepo;

import lombok.Data;
@Service
@Data
public class VehicleService {

	@Autowired
	private VehicleRepo vehiclerepo;
	
	public Vehicle createVechicle(Vehicle vehicle) {
		return vehiclerepo.save(vehicle);
		
	}
	
	public Optional<Vehicle> getVehicleById(Long id) {
		return vehiclerepo.findById(id);
	}
		
	
}
