package com.efarmkart.app.repository.adminRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.adminModel.StoreHubTransfer;

@Repository
public interface StoreHubTransferRepo extends JpaRepository<StoreHubTransfer, Long>{

}
