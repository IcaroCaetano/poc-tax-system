package com.myprojecticaro.poc_tax_service.domain.model;

public class State {
	
    private final Long id;
    
    private final String name;
    
    private final String code;

    public State(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Long getId() { return id; }
    
    public String getName() { return name; }
    
    public String getCode() { return code; }
}