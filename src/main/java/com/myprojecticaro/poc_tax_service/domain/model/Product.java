package com.myprojecticaro.poc_tax_service.domain.model;
import java.util.List;

public class Product {
	
    private final Long id;
    
    private final String name;
    
    private final String category;
    
    private final List<TaxRate> taxRates;

    public Product(Long id, String name, String category, List<TaxRate> taxRates) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.taxRates = taxRates;
    }

    public Long getId() { return id; }
    
    public String getName() { return name; }
    
    public String getCategory() { return category; }
    
    public List<TaxRate> getTaxRates() { return taxRates; }
}