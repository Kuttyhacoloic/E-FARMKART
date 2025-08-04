package com.efarmkart.app.service.darkHubService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.darkHubModel.InventoryItem;
import com.efarmkart.app.repository.darkHubRepository.InventoryItemRepo;

@Service
public class InventoryItemService {
	
	@Autowired
	private InventoryItemRepo inventoryIteamservice;
	
	public List<InventoryItem> getAlliteam(){
		return inventoryIteamservice.findAll();
		
	}
	
	public InventoryItem createItem(InventoryItem inventoryItem) {
		return inventoryIteamservice.save(inventoryItem);
	}

	public Optional<InventoryItem> findItemById(Long id){
		return inventoryIteamservice.findById(id);
	}
	
	public List<InventoryItem> findByCondition(String condition){
		return inventoryIteamservice.findByCondition(condition);
	}
	
	public InventoryItem findByName(String productName) {
		return inventoryIteamservice.findByName(productName);
	}
	
	public InventoryItem findByProductCode(String productCode) {
		return inventoryIteamservice.findByproductCode(productCode);
	}
	
	public void deleteById(Long id) {
		inventoryIteamservice.deleteById(id);
	}
}

