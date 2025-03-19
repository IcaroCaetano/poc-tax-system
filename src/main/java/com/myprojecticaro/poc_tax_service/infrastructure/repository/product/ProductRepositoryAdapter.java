package com.myprojecticaro.poc_tax_service.infrastructure.repository.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.myprojecticaro.poc_tax_service.application.port.ProductRepositoryPort;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;

@Repository	
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    
	private final SpringDataProductRepository repository;

    public ProductRepositoryAdapter(SpringDataProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return repository.save(product);
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}