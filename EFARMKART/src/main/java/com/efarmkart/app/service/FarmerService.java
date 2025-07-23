package com.efarmkart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.Farmer;
import com.efarmkart.app.repository.FarmerRepo;

import lombok.Data;

@Service
@Data
public class FarmerService {

    @Autowired
    private FarmerRepo farmerRepository;
    
    public List<Farmer> getAllFarmers() {
    	return farmerRepository.findAll();
    	
    }

    public Farmer createFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public Optional<Farmer> getFarmerById(Long id) {
        return farmerRepository.findById(id);
    }
}
