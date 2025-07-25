package com.efarmkart.app.repository.darkHubRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.Consignment;

@Repository
public interface ConsignmentRepo extends JpaRepository<Consignment, Long> {

}
