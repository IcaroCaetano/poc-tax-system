package com.myprojecticaro.poc_tax_service.application.request.dto;

import java.math.BigDecimal;

public record TaxRateDTO(Long stateId, Integer fiscalYear, BigDecimal taxPercentage) {}