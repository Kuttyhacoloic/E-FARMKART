package com.efarmkart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.Procurement;
import com.efarmkart.app.repository.ProcurementRepo;

@Service
public class ProcurementService {

    @Autowired
    private ProcurementRepo procurementRepository;
    
    public List<Procurement> getAllProcurement(){
    	return procurementRepository.findAll()
;    }

    public Procurement createProcurement(Procurement procurement) {
        return procurementRepository.save(procurement);
    }

    public Optional<Procurement> getProcurementById(Long id) {
        return procurementRepository.findById(id);
    }
}
