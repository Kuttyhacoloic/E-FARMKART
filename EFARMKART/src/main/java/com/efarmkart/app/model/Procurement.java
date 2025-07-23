package com.efarmkart.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.efarmkart.app.model.Employee;
import com.efarmkart.app.model.Warehouse;
import com.efarmkart.app.model.Vehicle;

@Entity
@Data
public class Procurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long procurementId;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String batchId;
    private int quantity;
    private double rate;
    private double totalPrice;

    private LocalDateTime collectionDate;

    @ManyToOne
    @JoinColumn(name = "handler_id")
    private Employee handler;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle; // optional
}
