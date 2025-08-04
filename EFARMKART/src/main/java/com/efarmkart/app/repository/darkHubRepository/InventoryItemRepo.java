package com.efarmkart.app.repository.darkHubRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.InventoryItem;

@Repository
public interface InventoryItemRepo extends JpaRepository<InventoryItem, Long> {
	public List<InventoryItem> findByCondition(String condition); 
	public InventoryItem findByName(String productName);
	public InventoryItem findByproductCode(String productCode);

}
