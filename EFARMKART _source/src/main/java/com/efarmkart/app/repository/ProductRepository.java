package com.efarmkart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.Farmer;
import com.efarmkart.app.model.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {

}
