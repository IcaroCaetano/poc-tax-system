package com.myprojecticaro.poc_tax_service.infrastructure.repository.state;


import com.myprojecticaro.poc_tax_service.application.port.StateRepositoryPort;
import com.myprojecticaro.poc_tax_service.domain.model.State;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StateRepositoryAdapter implements StateRepositoryPort {

    private final SpringDataStateRepository repository;

    public StateRepositoryAdapter(SpringDataStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public StateEntity save(StateEntity state) {
        return repository.save(state);
    }

    @Override
    public void deleteById(Long id) {
    	repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByCode(String code) {
        return repository.existsByCode(code);
    }

    @Override
    public Optional<State> findById(Long id) {
        return repository.findById(id).map(State::toModel);
    }
    
    @Override
    public List<State> findAll() {
        return repository.findAll().stream()
            .map(State::toModel)
            .collect(Collectors.toList());
    }
}
