package com.myprojecticaro.poc_tax_service.infrastructure.repository.mapper;

import com.myprojecticaro.poc_tax_service.domain.model.State;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;
import java.util.List;
import java.util.stream.Collectors;

public class StateMapper {

    public static State toModel(StateEntity entity) {
        return new State(entity.getId(), entity.getName(), entity.getCode());
    }

    public static StateEntity toEntity(State state) {
        return new StateEntity(state.getId(), state.getName(), state.getCode());
    }

    public static List<State> toModelList(List<StateEntity> entities) {
        return entities.stream().map(StateMapper::toModel).collect(Collectors.toList());
    }
}
