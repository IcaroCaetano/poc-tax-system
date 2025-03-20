package com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;
    
    private String category;
    
    private String brand;
    
    private String serialNumber;

	public ProductEntity() {
		super();
	}

	public ProductEntity(Long id, String name, String category, String brand, String serialNumber) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.serialNumber = serialNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", category=" + category + ", brand=" + brand
				+ ", serialNumber=" + serialNumber + "]";
	}
	 
}
