package com.myprojecticaro.poc_tax_service.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sale {
	
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
    private BigDecimal price;
    private BigDecimal taxAmount;
	
    public Sale() {
		super();
	}

	public Sale(Long id, Product product, State state, Integer year, BigDecimal price, BigDecimal taxAmount) {
		super();
		this.id = id;
		this.product = product;
		this.state = state;
		this.year = year;
		this.price = price;
		this.taxAmount = taxAmount;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", product=" + product + ", state=" + state + ", year=" + year + ", price=" + price
				+ ", taxAmount=" + taxAmount + "]";
	}  
}