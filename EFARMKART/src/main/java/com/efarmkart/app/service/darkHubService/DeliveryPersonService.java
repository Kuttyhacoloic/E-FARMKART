package com.efarmkart.app.service.darkHubService;

import java.util.List;
import java.util.Optional;

import com.efarmkart.app.repository.darkHubRepository.InventoryItemRepo;
import com.efarmkart.app.repository.darkHubRepository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.efarmkart.app.EfarmkartApplication;
import com.efarmkart.app.model.darkHubModel.DeliveryPerson;
import com.efarmkart.app.model.darkHubModel.Order;
import com.efarmkart.app.repository.darkHubRepository.DeliveryPersonRepo;

@Service
public class DeliveryPersonService {

    private final ReportRepo reportRepo;

    private final EfarmkartApplication efarmkartApplication;
	
	@Autowired
    private InventoryItemRepo inventoryItemRepo;
	
	private DeliveryPersonRepo deliveryperosonSer;

    DeliveryPersonService(InventoryItemRepo inventoryItemRepo, EfarmkartApplication efarmkartApplication, ReportRepo reportRepo) {
        this.inventoryItemRepo = inventoryItemRepo;
        this.efarmkartApplication = efarmkartApplication;
        this.reportRepo = reportRepo;
    }
    
    public List<DeliveryPerson> getAll(){
    	return deliveryperosonSer.findAll();
    }
    
    public DeliveryPerson createDelivery(DeliveryPerson deliveryPerson) {
    	return deliveryperosonSer.save(deliveryPerson);
    }
    
    public Optional<DeliveryPerson> findPersonById(Long id) {
    	return deliveryperosonSer.findById(id);
    }
    
    public List<DeliveryPerson> findPersonByStatus(String status){
    	return deliveryperosonSer.findAll();
    }
    
    public DeliveryPerson findByVechicalId(String vehicleNumber) {
    	return deliveryperosonSer.findByVechicalId(vehicleNumber);
    }
    
    public void deletePerson(Long id) {
    	deliveryperosonSer.deleteById(id);
    }
}