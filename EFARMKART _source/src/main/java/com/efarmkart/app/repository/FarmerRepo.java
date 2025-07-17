package com.efarmkart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.Farmer;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Long>{

}
