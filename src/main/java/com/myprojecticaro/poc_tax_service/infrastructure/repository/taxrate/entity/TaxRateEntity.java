package com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate.entity;

import java.math.BigDecimal;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tax_rates")
public class TaxRateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;
    
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private StateEntity state;
    
   @Column(name = "fiscal_year")
    private Integer fiscalYear;
    private BigDecimal taxPercentage;
	
    public TaxRateEntity() {
		super();
	}

	public TaxRateEntity(Long id, ProductEntity product, StateEntity state, Integer fiscalYear, BigDecimal taxPercentage) {
		super();
		this.id = id;
		this.product = product;
		this.state = state;
		this.fiscalYear = fiscalYear;
		this.taxPercentage = taxPercentage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public StateEntity getState() {
		return state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

	public Integer getYear() {
		return fiscalYear;
	}

	public void setFiscalYear(Integer fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public BigDecimal getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	@Override
	public String toString() {
		return "TaxRate [id=" + id + ", product=" + product + ", state=" + state + ", fiscalYear=" + fiscalYear + ", taxPercentage="
				+ taxPercentage + "]";
	}
}