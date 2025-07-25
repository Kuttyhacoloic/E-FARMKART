package com.efarmkart.app.model.darkHubModel;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referenceCode;
    private String status; // INBOUND, OUTBOUND, RETURNED
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "dark_hub_id")
    private DarkHub darkHub;
}
