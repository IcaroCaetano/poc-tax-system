package com.myprojecticaro.poc_tax_service.application.request.dto;

import java.math.BigDecimal;
import com.myprojecticaro.poc_tax_service.domain.model.TaxRate;

public record TaxRateDTORequest(
    int fiscalYear,
    Long productId,
    Long stateId,
    BigDecimal taxPercentage
) {

    public TaxRate toModel() {
        return new TaxRate(
            null,
            this.fiscalYear,
            this.productId,
            this.stateId,
            this.taxPercentage
        );
    }
}
