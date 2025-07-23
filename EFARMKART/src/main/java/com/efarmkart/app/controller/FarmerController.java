package com.efarmkart.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efarmkart.app.DTO.FarmerDTO;
import com.efarmkart.app.exception.ResourceNotFoundException;
import com.efarmkart.app.model.Farmer;
import com.efarmkart.app.repository.FarmerRepo;
import com.efarmkart.app.response.ApiResponse;
import com.efarmkart.app.service.FarmerService;
import com.efarmkart.app.service.VehicleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/farmers")
@RequiredArgsConstructor
public class FarmerController{ 
    private VehicleService vehicleService;

    private  final FarmerService farmerService;
    private  final FarmerRepo farmerRepo;
    
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Farmer>>> getAllFarmers() {
    	
        try {
            List<Farmer> farmers = farmerService.getAllFarmers();
            return ResponseEntity.ok(new ApiResponse<>("Farmers found", farmers, true));
        } 
        
        catch (Exception e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            		.body(new ApiResponse<>("Farmers not found", null, false));
        }
    }

    
    @PostMapping 
    public ResponseEntity<Farmer> createFarmer(@RequestBody Farmer farmer) {
    	return ResponseEntity.ok(farmerRepo.save(farmer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Farmer>> getFarmerById(@PathVariable Long id) {
    	
   return farmerService.getFarmerById(id).map((f)->{
	   
	   ApiResponse<Farmer> res = new ApiResponse<Farmer>("Found", f,true);
	   return ResponseEntity.ok(res);
   }).orElseGet(()->{
	   
	   ApiResponse<Farmer> res = new ApiResponse<Farmer>("Not Found", null ,false);
	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
   });
    	
    	
		/*
		 * try { Farmer farmar = farmerService.getFarmerById(id); return
		 * ResponseEntity.ok(new ApiResponse<>("Farmer Found", farmar, true)); }
		 * catch(Exception e) { return
		 * ResponseEntity.status(HttpStatus.NOT_FOUND).body(new
		 * ApiResponse<>("Farmer Not Found", null, false)); }
		 */
    }

 
}
