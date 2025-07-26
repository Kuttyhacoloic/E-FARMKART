package com.efarmkart.app.service.adminService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.adminModel.StoreHubTransfer;
import com.efarmkart.app.repository.adminRepo.StoreHubTransferRepo;

@Service
public class StoreHubTranferService {
	
	@Autowired
	private StoreHubTransferRepo storeRepo;
	
	public List<StoreHubTransfer> getAllTranser(){
		return storeRepo.findAll();
	}
	
	public StoreHubTransfer createHubTransfer(StoreHubTransfer hubTransfer) {
		
		return storeRepo.save(hubTransfer);
	}
	
	public Optional<StoreHubTransfer> getTranferById(Long id){
		return storeRepo.findById(id);
	} 
	
	public Optional<StoreHubTransfer> deleteStoreHubTransferById(Long id) {
	    Optional<StoreHubTransfer> transferOptional = storeRepo.findById(id);
	    transferOptional.ifPresent(storeRepo::delete);
	    return transferOptional;
	}

}
