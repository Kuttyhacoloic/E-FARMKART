package com.efarmkart.app.model.darkHubModel;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String orderNumber;
    private LocalDateTime orderTime;
    private String status; // PENDING, DISPATCHED, DELIVERED, CANCELLED

    @ManyToOne
    @JoinColumn(name = "dark_hub_id")
    private DarkHub darkHub;

}
