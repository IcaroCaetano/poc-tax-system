package com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity;

import java.util.List;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate.entity.TaxRateEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class StateEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    
    @OneToMany(mappedBy = "state")
    private List<TaxRateEntity> taxRates;
    

	public StateEntity() {
		super();
	}

	public StateEntity(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public StateEntity(Long id, String name, String code, List<TaxRateEntity> taxRates) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<TaxRateEntity> getTaxRates() {
		return taxRates;
	}

	public void setTaxRates(List<TaxRateEntity> taxRates) {
		this.taxRates = taxRates;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", code=" + code + ", taxRates=" + taxRates + "]";
	}
}