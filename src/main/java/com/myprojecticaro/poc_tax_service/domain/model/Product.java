package com.myprojecticaro.poc_tax_service.domain.model;

public class Product {
	
    private final Long id;
    
    private final String name;
    
    private String category;
    
    private String brand;
    
    private String serialNumber;

    public Product(Long id, String name, String category, String brand, String serialNumber) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.serialNumber = serialNumber;
	}

	public Long getId() { return id; }
    
    public String getName() { return name; }

	public String getCategory() { return category; }

	public String getBrand() { return brand; }

	public String getSerialNumber() { return serialNumber; }
}