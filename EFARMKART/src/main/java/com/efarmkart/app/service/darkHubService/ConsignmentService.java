package com.efarmkart.app.service.darkHubService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.darkHubModel.Consignment;
import com.efarmkart.app.repository.darkHubRepository.ConsignmentRepo;

@Service
public class ConsignmentService {

	@Autowired
	private ConsignmentRepo consignmentRepo;
	
	public List<Consignment> getAllConsignment(){
		return consignmentRepo.findAll();
	}
	
	public Consignment createConsignment(Consignment consignment) {
		return consignmentRepo.save(consignment);
	}
	
	public List<Consignment> findConsignmentByStatus(String status){
		return consignmentRepo.findAll();
		}
	
	
}
