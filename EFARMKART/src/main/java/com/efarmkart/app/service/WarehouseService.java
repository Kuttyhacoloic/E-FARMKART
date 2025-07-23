package com.efarmkart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.Warehouse;
import com.efarmkart.app.repository.WarehouseRepo;

@Service
public class WarehouseService {

	@Autowired
	private WarehouseRepo warehouserepo;
	
	public List<Warehouse> getAllWarehouse() {
		return warehouserepo.findAll();
	}
	
	public Warehouse CreateWarehouse(Warehouse warehouse) {
		return warehouserepo.save(warehouse);
	}
	
	public Optional<Warehouse> getWarehouseById(Long id) {
		return warehouserepo.findById(id);
	}
}
