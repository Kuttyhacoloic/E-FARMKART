package com.efarmkart.app.repository.darkHubRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.ProductPicker;

@Repository
public interface ProductPickerRepo extends JpaRepository<ProductPicker, Long> {

}
