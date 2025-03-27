package com.myprojecticaro.poc_tax_service.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojecticaro.poc_tax_service.application.port.StateRepositoryPort;
import com.myprojecticaro.poc_tax_service.domain.model.State;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;

@Service
public class StateService {

    private final StateRepositoryPort stateRepositoryPort;

    public StateService(StateRepositoryPort stateRepositoryPort) {
        this.stateRepositoryPort = stateRepositoryPort;
    }

    @Transactional
    public StateEntity createState(String name, String code) {
        if (stateRepositoryPort.existsByCode(code)) {
            throw new IllegalArgumentException("Já existe um estado com este código: " + code);
        }
        StateEntity state = new StateEntity(null, name, code);
        return stateRepositoryPort.save(state);
    }

    @Transactional
    public void deleteState(Long id) {
        if (!stateRepositoryPort.existsById(id)) {
            throw new IllegalArgumentException("Estado não encontrado com ID: " + id);
        }
        stateRepositoryPort.deleteById(id);
    }
    
    @Transactional(readOnly = true)
    public List<State> getAllStates() {
        return stateRepositoryPort.findAll();
    }
}
