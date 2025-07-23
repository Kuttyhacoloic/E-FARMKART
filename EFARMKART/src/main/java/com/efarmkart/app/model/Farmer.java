package com.efarmkart.app.model;
import com.efarmkart.darkStore.app.EfarmkartApplication;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmerId;

    private String name;
    private String phone;
    private String villageName;
    private String district;
    private String state;
    private String bankAccount;
    private String aadhaarNumber;
}
