package com.myprojecticaro.poc_tax_service.domain.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate.entity.TaxRateEntity;

public record TaxRate(Long id, int fiscalYear, Long productId, Long stateId, BigDecimal taxPercentage) {
    
	public static TaxRate fromEntity(TaxRateEntity entity) {
        return new TaxRate(
            entity.getId(),
            entity.getYear(),
            entity.getProduct().getId(),
            entity.getState().getId(),
            entity.getTaxPercentage()
        );
    }
	
	 public static List<TaxRate> fromEntities(List<TaxRateEntity> entities) {
	        return entities.stream()
	            .map(TaxRate::fromEntity)
	            .collect(Collectors.toList());
	    }
	 
	 public TaxRateEntity toEntity(ProductEntity product, StateEntity state) {
	        return new TaxRateEntity(
	            id,
	            product,
	            state,
	            fiscalYear,
	            taxPercentage
	        );
	    }
}