package com.efarmkart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efarmkart.app.exception.ResourceNotFoundException;
import com.efarmkart.app.model.Product;
import com.efarmkart.app.response.ApiResponse;
import com.efarmkart.app.service.ProductService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@Data
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<Product>>> getAllProduct(){
		try {
			List<Product> product = productService.getAllProduct();
			return ResponseEntity.ok(new ApiResponse<>("products found ", product , true));
			
		} catch (Exception e) {
			List<Product> product = productService.getAllProduct();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("products not found ", null, false));
			
		}
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody Product product)
	{
	    Product prod = productService.createProduct(product);
	    ApiResponse<Product> response  = new ApiResponse<Product>("Product created successfully", prod, true); 
		
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Product>> getProduct(@PathVariable Long id){
		 
		return productService.getProductById(id).map((p)->{
			
			return ResponseEntity.ok(new ApiResponse<>("product found", p , true));
		}).orElseThrow(()-> new ResourceNotFoundException("product not found"));
	}

}
