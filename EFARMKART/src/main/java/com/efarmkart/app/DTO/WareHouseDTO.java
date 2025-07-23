package com.efarmkart.app.DTO;

import lombok.Data;

@Data
public class WareHouseDTO {
	
	private Long warehouseId;
	private String name;
	private String location;
	private int capacity;
	private Long managerId;
	private String managerName;

}
