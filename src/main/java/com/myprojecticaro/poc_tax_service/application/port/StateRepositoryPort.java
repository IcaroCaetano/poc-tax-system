package com.myprojecticaro.poc_tax_service.application.port;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;

import java.util.List;
import java.util.Optional;

public interface StateRepositoryPort {
    StateEntity save(StateEntity state);
    
    void deleteById(Long id);
    
    boolean existsById(Long id);
    
    boolean existsByCode(String code);
    
    Optional<StateEntity> findById(Long id);
    
    List<StateEntity> findAll();
}
