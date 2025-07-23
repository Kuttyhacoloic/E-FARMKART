package com.efarmkart.app.DTO;

import lombok.Data;

@Data
public class ProductDTO {

	   private Long productId;
	    private String name;
	    private String category; // String for simplicity, can be Enum
	    private String unit;     // String for simplicity, can be Enum
	    private double pricePerUnit;
	    private boolean isPerishable;
}
