package com.efarmkart.app.service.darkHubService;

import java.util.List;
import java.util.Optional;
import com.efarmkart.app.repository.darkHubRepository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.darkHubModel.Order;
import com.efarmkart.app.repository.darkHubRepository.OrderRepo;

@Service
public class OrderService {
	 
	@Autowired
	private OrderRepo orderRepo;

   
	
	public List<Order> getAll(){
		return orderRepo.findAll();
	}
	
	public Order createOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public Optional<Order> findBYId(Long id){
		return orderRepo.findById(id);
	}
	
	public List<Order> findByStatus(String status){
		return orderRepo.findByStatus(status);
	}
	
	public List<Order> findByTime(String orderTime){
		return orderRepo.findByTime(orderTime);
	}
	
	public Optional<Order> findByOrderNumber(String orderNumber){
		return orderRepo.findByOrderNumber(orderNumber);
	}
	
	public void deleteOrder(Long id) {
		orderRepo.deleteById(id);
	}
}
