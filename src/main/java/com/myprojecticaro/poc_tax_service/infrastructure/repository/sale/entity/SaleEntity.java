package com.myprojecticaro.poc_tax_service.infrastructure.repository.sale.entity;

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

@Entity
public class SaleEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    
    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateEntity state;
    
   @Column(name = "sale_year")
    private Integer year;
    private BigDecimal price;
    private BigDecimal taxAmount;
	
    public SaleEntity() {
		super();
	}

	public SaleEntity(Long id, ProductEntity product, StateEntity state, Integer year, BigDecimal price, BigDecimal taxAmount) {
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