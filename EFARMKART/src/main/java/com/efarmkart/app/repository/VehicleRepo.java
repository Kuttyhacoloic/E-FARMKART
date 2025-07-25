package com.efarmkart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long>{

}
