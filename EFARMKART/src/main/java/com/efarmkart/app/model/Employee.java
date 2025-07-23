package com.efarmkart.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import com.efarmkart.app.enumuration.Role;

@Entity
@Data
public class Employee {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String phone;

    @ManyToOne   
    @JoinColumn(name = "assigned_warehouse_id")
    private Warehouse assignedWarehouse;
}
