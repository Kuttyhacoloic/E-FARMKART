package com.efarmkart.app.repository.darkHubRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.DeliveryPerson;

@Repository
public interface DeliveryPersonRepo extends JpaRepository<DeliveryPerson, Long> {

}
