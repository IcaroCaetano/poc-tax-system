package com.myprojecticaro.poc_tax_service.domain.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class State {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String abbreviation; // Ex: "SP", "RJ", "MG"
    
    @OneToMany(mappedBy = "state")
    private List<TaxRate> taxRates;
    

	public State() {
		super();
	}
	

	public State(Long id, String name, String abbreviation, List<TaxRate> taxRates) {
		super();
		this.id = id;
		this.name = name;
		this.abbreviation = abbreviation;
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

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public List<TaxRate> getTaxRates() {
		return taxRates;
	}

	public void setTaxRates(List<TaxRate> taxRates) {
		this.taxRates = taxRates;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + ", taxRates=" + taxRates + "]";
	}
}