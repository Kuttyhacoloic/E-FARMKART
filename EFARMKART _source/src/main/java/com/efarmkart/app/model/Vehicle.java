package com.efarmkart.app.model;

import com.efarmkart.app.enumuration.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import com.efarmkart.app.enumuration.VehicleType;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private String plateNumber;
    private int capacity;
    private boolean isTempControlled;
}
