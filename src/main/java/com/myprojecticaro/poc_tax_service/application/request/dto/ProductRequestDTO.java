package com.myprojecticaro.poc_tax_service.application.request.dto;

import com.myprojecticaro.poc_tax_service.domain.model.Product;

public record ProductRequestDTO(String name, String category, String brand, String serialNumber) {
	
	public Product toProduct(ProductRequestDTO dto) {
        return new Product(null, dto.name(), dto.category(), dto.brand(), dto.serialNumber());
	}
}