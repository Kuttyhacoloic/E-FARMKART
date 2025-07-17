package com.efarmkart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.Product;
import com.efarmkart.app.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;
    
    public List<Product> getAllProduct() {
    	return productRepo.findAll();
    	}

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }
    
   
}
