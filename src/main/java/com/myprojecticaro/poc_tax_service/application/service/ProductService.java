package com.myprojecticaro.poc_tax_service.application.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.myprojecticaro.poc_tax_service.application.port.ProductRepositoryPort;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;

@Service
public class ProductService {

    private final ProductRepositoryPort productRepository;

    public ProductService(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}