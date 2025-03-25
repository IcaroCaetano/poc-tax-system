package com.myprojecticaro.poc_tax_service.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myprojecticaro.poc_tax_service.application.request.dto.TaxRateDTORequest;
import com.myprojecticaro.poc_tax_service.application.service.TaxRateService;

import com.myprojecticaro.poc_tax_service.domain.model.TaxRate;

@RestController
@RequestMapping("/api/tax-rates")
public class TaxRateController {

    private final TaxRateService taxRateService;

    public TaxRateController(TaxRateService taxRateService) {
        this.taxRateService = taxRateService;
    }

    @PostMapping
    public ResponseEntity<TaxRate> createTaxRate(@RequestBody TaxRateDTORequest taxRateDTORequest) {
        TaxRate taxRate = taxRateDTORequest.toModel();
        TaxRate createdTaxRate = taxRateService.createTaxRate(taxRate);
        return ResponseEntity.ok(createdTaxRate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxRate> getTaxRateById(@PathVariable Long id) {
        Optional<TaxRate> taxRate = taxRateService.getTaxRateById(id);
        return taxRate.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TaxRate>> getAllTaxRates() {
        List<TaxRate> taxRates = taxRateService.getAllTaxRates();
        return ResponseEntity.ok(taxRates);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaxRate(@PathVariable Long id) {
        taxRateService.deleteTaxRate(id);
        return ResponseEntity.noContent().build();
    }
}
