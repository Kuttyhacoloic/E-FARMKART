package com.efarmkart.app.model.darkHubModel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String productCode;
    private int quantity;
    
    @Column(name = "item_condition")
    private String condition; // GOOD, DAMAGED, OLD, EXPIRED

    @ManyToOne
    @JoinColumn(name = "dark_hub_id")
    private DarkHub darkHub;
}