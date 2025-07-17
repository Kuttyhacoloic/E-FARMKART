package com.efarmkart.app.DTO;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	private Long employeeId;
	private String name;
	private String role;
	private String phone;
	private Long assignedWarehouseId;
	private String assignedWarehouseName;

}
