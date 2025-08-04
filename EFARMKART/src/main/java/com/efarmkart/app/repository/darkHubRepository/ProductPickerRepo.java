package com.efarmkart.app.repository.darkHubRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.ProductPicker;

@Repository
public interface ProductPickerRepo extends JpaRepository<ProductPicker, Long> {
	
	public Optional<ProductPicker>  findByName(String name);
	public List<ProductPicker> findByShift(String shift);

}
