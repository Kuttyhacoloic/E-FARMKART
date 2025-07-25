package com.efarmkart.app.model.darkHubModel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPicker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String shift;
    private String status; // ACTIVE, INACTIVE

    @ManyToOne
    @JoinColumn(name = "dark_hub_id")
    private DarkHub darkHub;
}