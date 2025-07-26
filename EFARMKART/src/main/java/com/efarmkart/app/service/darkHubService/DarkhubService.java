package com.efarmkart.app.service.darkHubService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.darkHubModel.DarkHub;
import com.efarmkart.app.repository.darkHubRepository.DarkhubRepo;

@Service
public class DarkhubService {

	@Autowired
	private DarkhubRepo darkHubRepo;
//	private boolean isActive;

	
	public List<DarkHub> getAllHub(){
		return darkHubRepo.findAll();
	}
	
	public DarkHub createHub(DarkHub darkHub) {
		darkHub.setActive(true); 
		return darkHubRepo.save(darkHub);
	}
	
	public List<DarkHub>  getByStatus(Boolean isActive) {
		return darkHubRepo.findByIsActive(isActive);
	}
	
	public Optional<DarkHub> getByHubName(String name){
		return darkHubRepo.findByName(name);
	}
	
	public boolean updateHub(String name, boolean isActive) {
	    return darkHubRepo.updateHubStatusByName(name, isActive) > 0;
	}

	public Optional<DarkHub> deleteById(Long id){
	    Optional<DarkHub> hub = darkHubRepo.findById(id);
	    hub.ifPresent(darkHubRepo::delete);  
	    return hub;
	}

}
