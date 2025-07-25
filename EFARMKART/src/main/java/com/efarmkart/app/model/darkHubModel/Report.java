package com.efarmkart.app.model.darkHubModel;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // INVENTORY, DELIVERY, SALES, etc.
    private LocalDate generatedOn;
    private String summary;

    @ManyToOne
    @JoinColumn(name = "dark_hub_id")
    private DarkHub darkHub;
}