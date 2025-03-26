package com.myprojecticaro.poc_tax_service.domain.model;

import java.util.List;
import java.util.stream.Collectors;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;

public record State(
    Long id,
    String name,
    String code
) {
	public static State toModel(StateEntity entity) {
        return new State(entity.getId(), entity.getName(), entity.getCode());
    }

    public static StateEntity toEntity(State state) {
        return new StateEntity(state.id(), state.name(), state.code());
    }

    public static List<State> toModelList(List<StateEntity> entities) {
        return entities.stream().map(State::toModel).collect(Collectors.toList());
    }
    
    
}