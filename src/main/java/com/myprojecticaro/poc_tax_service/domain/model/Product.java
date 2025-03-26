package com.myprojecticaro.poc_tax_service.domain.model;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;

public record Product(
    Long id,
    String name,
    String category,
    String brand,
    String serialNumber
) {
    public ProductEntity toProductEntity(Product product) {
        return new ProductEntity(
            product.id(),
            product.name(),
            product.category(),
            product.brand(),
            product.serialNumber()
        );
    }
}