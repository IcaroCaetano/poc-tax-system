package com.myprojecticaro.poc_tax_service.infrastructure.repository.mapper;

import com.myprojecticaro.poc_tax_service.domain.model.State;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;

public class StateMapper {

    public static State toDomain(StateEntity entity) {
        return new State(entity.getId(), entity.getName(), entity.getCode());
    }

    public static StateEntity toEntity(State domain) {
    	
        return new StateEntity(domain.getId(), domain.getName(), domain.getCode());
    }
}