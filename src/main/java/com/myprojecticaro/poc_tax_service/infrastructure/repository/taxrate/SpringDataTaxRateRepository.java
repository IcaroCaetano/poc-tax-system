package com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate.entity.TaxRateEntity;

@Repository
public interface SpringDataTaxRateRepository extends JpaRepository<TaxRateEntity, Long> {
	
}
    