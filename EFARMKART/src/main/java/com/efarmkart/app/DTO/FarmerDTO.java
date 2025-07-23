package com.efarmkart.app.DTO;

import lombok.Data;

@Data
public class FarmerDTO {

    private Long farmerId;
    private String name;
    private String phone;
    private String villageName;
    private String district;
    private String state;
    private String bankAccount;
}
