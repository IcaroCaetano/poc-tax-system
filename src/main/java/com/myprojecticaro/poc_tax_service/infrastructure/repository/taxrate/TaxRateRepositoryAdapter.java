package com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.myprojecticaro.poc_tax_service.application.port.TaxRateRepositoryPort;
import com.myprojecticaro.poc_tax_service.domain.model.TaxRate;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.SpringDataProductRepository;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.SpringDataStateRepository;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate.entity.TaxRateEntity;

@Repository
public class TaxRateRepositoryAdapter implements TaxRateRepositoryPort {

    private final SpringDataTaxRateRepository taxRateRepository;
    private final SpringDataProductRepository productRepository;
    private final SpringDataStateRepository stateRepository;

    public TaxRateRepositoryAdapter(
        SpringDataTaxRateRepository taxRateRepository,
        SpringDataProductRepository productRepository,
        SpringDataStateRepository stateRepository
    ) {
        this.taxRateRepository = taxRateRepository;
        this.productRepository = productRepository;
        this.stateRepository = stateRepository;
    }

    @Override
    public TaxRate save(TaxRate taxRate) {
        var product = productRepository.findById(taxRate.productId())
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        
        var state = stateRepository.findById(taxRate.stateId())
            .orElseThrow(() -> new IllegalArgumentException("State not found"));

        TaxRateEntity entity = taxRate.toEntity(product, state);
        TaxRateEntity savedEntity = taxRateRepository.save(entity);
        return TaxRate.fromEntity(savedEntity);
    }

    @Override
    public Optional<TaxRate> findById(Long id) {
        return taxRateRepository.findById(id).map(TaxRate::fromEntity);
    }

    @Override
    public List<TaxRate> findAll() {
        return TaxRate.fromEntities(taxRateRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        taxRateRepository.deleteById(id);
    }
}
