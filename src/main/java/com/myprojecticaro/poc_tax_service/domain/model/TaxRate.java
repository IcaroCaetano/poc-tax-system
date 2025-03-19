package com.myprojecticaro.poc_tax_service.domain.model;

import java.math.BigDecimal;  
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TaxRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
    
    private Integer year;
    private BigDecimal taxPercentage;
	
    public TaxRate() {
		super();
	}

	public TaxRate(Long id, Product product, State state, Integer year, BigDecimal taxPercentage) {
		super();
		this.id = id;
		this.product = product;
		this.state = state;
		this.year = year;
		this.taxPercentage = taxPercentage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	@Override
	public String toString() {
		return "TaxRate [id=" + id + ", product=" + product + ", state=" + state + ", year=" + year + ", taxPercentage="
				+ taxPercentage + "]";
	}
}