package com.myprojecticaro.poc_tax_service.domain.model;
import java.math.BigDecimal;

public class TaxRate {
	
    private final Long id;
    
    private final String state;
    
    private final int year;
    
    private final BigDecimal rate;
    
    private final Product product;

    public TaxRate(Long id, String state, int year, BigDecimal rate, Product product) {
        this.id = id;
        this.state = state;
        this.year = year;
        this.rate = rate;
        this.product = product;
    }

    public Long getId() { return id; }
    
    public String getState() { return state; }
    
    public int getYear() { return year; }
    
    public BigDecimal getRate() { return rate; }
    
    public Product getProduct() { return product; }
    
}