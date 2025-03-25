package com.myprojecticaro.poc_tax_service.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojecticaro.poc_tax_service.application.port.TaxRateRepositoryPort;
import com.myprojecticaro.poc_tax_service.domain.model.TaxRate;

@Service
public class TaxRateService {

    private final TaxRateRepositoryPort taxRateRepository;

    public TaxRateService(TaxRateRepositoryPort taxRateRepository) {
        this.taxRateRepository = taxRateRepository;
    }

    @Transactional
    public TaxRate createTaxRate(TaxRate taxRate) {
        return taxRateRepository.save(taxRate);
    }

    public Optional<TaxRate> getTaxRateById(Long id) {
        return taxRateRepository.findById(id);
    }

    public List<TaxRate> getAllTaxRates() {
        return taxRateRepository.findAll();
    }

    @Transactional
    public void deleteTaxRate(Long id) {
        if (taxRateRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Tax rate not found");
        }
        taxRateRepository.deleteById(id);
    }
}
