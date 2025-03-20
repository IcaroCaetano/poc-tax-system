package com.myprojecticaro.poc_tax_service.application.mapper;

import com.myprojecticaro.poc_tax_service.application.request.dto.ProductRequestDTO;
import com.myprojecticaro.poc_tax_service.domain.model.Product;

public class Mapper {
	
	public static Product toProduct(ProductRequestDTO dto) {
        return new Product(null, dto.name());
	}

}