package com.efarmkart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.Warehouse;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse , Long >{

}
