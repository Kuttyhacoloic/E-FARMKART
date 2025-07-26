package com.efarmkart.app.repository.darkHubRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.Complaint;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Long> {
	 List<Complaint> findByStatusIgnoreCase(String status);
}
