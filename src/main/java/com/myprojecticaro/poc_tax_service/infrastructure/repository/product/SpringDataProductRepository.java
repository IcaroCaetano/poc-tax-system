package com.myprojecticaro.poc_tax_service.infrastructure.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;

@Repository
public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long> {
	
}
    