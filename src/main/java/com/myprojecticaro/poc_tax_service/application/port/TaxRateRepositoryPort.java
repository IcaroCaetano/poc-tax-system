package com.myprojecticaro.poc_tax_service.application.port;

import java.util.List;
import java.util.Optional;

import com.myprojecticaro.poc_tax_service.domain.model.TaxRate;

public interface TaxRateRepositoryPort {
	
    TaxRate save(TaxRate taxRate);
    
    Optional<TaxRate> findById(Long id);
    
    List<TaxRate> findAll();
    
    void deleteById(Long id);
}
