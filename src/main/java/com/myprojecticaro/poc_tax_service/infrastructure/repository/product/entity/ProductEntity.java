package com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity;

import java.util.List;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate.entity.TaxRateEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ProductEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String category;
    
    @OneToMany(mappedBy = "product")
    private List<TaxRateEntity> taxRates;

	public ProductEntity() {
		super();
	}

	public ProductEntity(Long id, String name, String category, List<TaxRateEntity> taxRates) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.taxRates = taxRates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<TaxRateEntity> getTaxRates() {
		return taxRates;
	}

	public void setTaxRates(List<TaxRateEntity> taxRates) {
		this.taxRates = taxRates;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", taxRates=" + taxRates + "]";
	}	 
}
