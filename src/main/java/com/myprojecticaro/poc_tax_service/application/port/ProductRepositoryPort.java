package com.myprojecticaro.poc_tax_service.application.port;

import java.util.List;
import java.util.Optional;

import com.myprojecticaro.poc_tax_service.domain.model.Product;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;

public interface ProductRepositoryPort {
    
	ProductEntity save(Product product);
    
	Optional<ProductEntity> findById(Long id);
    
	List<ProductEntity> findAll();
	
    void deleteById(Long id);
}