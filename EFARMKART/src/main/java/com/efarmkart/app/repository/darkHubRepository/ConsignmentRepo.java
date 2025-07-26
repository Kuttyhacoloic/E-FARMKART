package com.efarmkart.app.repository.darkHubRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.Consignment;

@Repository
public interface ConsignmentRepo extends JpaRepository<Consignment, Long> {
	List<Consignment> findByStatus(String status);

}
