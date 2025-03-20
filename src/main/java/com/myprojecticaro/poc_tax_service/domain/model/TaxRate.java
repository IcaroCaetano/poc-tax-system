package com.myprojecticaro.poc_tax_service.domain.model;

public class TaxRate {

    private final Long id;
    
    private final int year;
    
    private final Long productId;  
    
    private final String code; 

    public TaxRate(Long id, int year, Long productId, String code) {
		super();
		this.id = id;
		this.year = year;
		this.productId = productId;
		this.code = code;
	}

	public Long getId() { return id; }
    
    public int getYear() { return year; }

	public Long getProductId() { return productId; }

	public String getCode() { return code; }  
}