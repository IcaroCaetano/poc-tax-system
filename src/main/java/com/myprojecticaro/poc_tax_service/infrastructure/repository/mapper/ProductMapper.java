package com.myprojecticaro.poc_tax_service.infrastructure.repository.mapper;

import com.myprojecticaro.poc_tax_service.domain.model.Product;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;

public class ProductMapper {

    public static ProductEntity toProductEntity(Product product) {

        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getBrand(),
                product.getSerialNumber()
        );
    }
}