package com.efarmkart.app.model.darkHubModel;


import lombok.*;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Data                                                         	
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String complaintType;
    private String description;
    private String status; // OPEN, IN_PROGRESS, RESOLVED
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "dark_hub_id")
    private DarkHub darkHub;
}
