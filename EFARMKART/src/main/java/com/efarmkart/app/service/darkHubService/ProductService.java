package com.efarmkart.app.service.darkHubService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.darkHubModel.Order;
import com.efarmkart.app.model.darkHubModel.ProductPicker;
import com.efarmkart.app.repository.darkHubRepository.ProductPickerRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductPickerRepo productPickerRepo;
	
	public List<ProductPicker> getAll(){
		return productPickerRepo.findAll();
	}
	
	public ProductPicker createProductPicker (ProductPicker productpick) {
		return productPickerRepo.save(productpick);
	}
	
	public Optional<ProductPicker> findById(Long id){
		return productPickerRepo.findById(id);
	}
	
	public Optional<ProductPicker> findByName(String name){
		return productPickerRepo.findByName(name);
	}
	
	public List<ProductPicker> findByShift(String shift){
		return productPickerRepo.findByShift(shift);
	}
	
	public void deletePicker(Long id) {
		productPickerRepo.deleteById(id);
	}
}
