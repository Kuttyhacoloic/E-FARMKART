package com.efarmkart.app.DTO;

import lombok.Data;

@Data
public class ProcurementDTO {
	
	    private Long procurementId;
	    private Long farmerId;
	    private Long productId;
	    private String batchId;
	    private int quantity;
	    private double rate;
	    private double totalPrice;
	    private String collectionDate;
	    private Long handlerId;
	    private Long warehouseId;

}
