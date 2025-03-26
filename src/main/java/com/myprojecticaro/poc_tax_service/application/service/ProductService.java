package com.myprojecticaro.poc_tax_service.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myprojecticaro.poc_tax_service.application.port.ProductRepositoryPort;
import com.myprojecticaro.poc_tax_service.domain.model.Product;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;

@Service
public class ProductService {

	private final ProductRepositoryPort productRepository;

    public ProductService(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream()
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getCategory(), entity.getBrand(), entity.getSerialNumber()))
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}