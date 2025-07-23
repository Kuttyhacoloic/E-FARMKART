package com.efarmkart.app.model;

import com.efarmkart.app.enumuration.ProductCategory;
import com.efarmkart.app.enumuration.UnitOfMeasurement;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.efarmkart.app.enumuration.ProductCategory;
import com.efarmkart.app.enumuration.UnitOfMeasurement;
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @Enumerated(EnumType.STRING)
    private UnitOfMeasurement unit;

    private double pricePerUnit;

    private boolean isPerishable;
}

