package com.efarmkart.app.repository.darkHubRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{
	
	public List<Order> findByStatus(String status);
	public List<Order> findByTime(String orderTime);
	public Optional<Order> findByOrderNumber(String orderNumber);

}
