package com.efarmkart.app.model.adminModel;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.efarmkart.app.model.Warehouse;
import com.efarmkart.app.model.darkHubModel.DarkHub;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreHubTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transferCode;
    private String status; // INITIATED, IN_TRANSIT, RECEIVED, RETURNED
    private LocalDateTime transferDate;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Warehouse darkStore; // assuming Warehouse = DarkStore

    @ManyToOne
    @JoinColumn(name = "hub_id")
    private DarkHub darkHub;
}