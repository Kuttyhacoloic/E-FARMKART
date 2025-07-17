package com.efarmkart.app.DTO;

import lombok.Data;

@Data
public class vechicalDTO {

	private Long vehicleId;
	private String type;
	private String plateNumber;
	private int capacity;
	private boolean isTempControlled;
}
