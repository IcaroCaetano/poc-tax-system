package com.myprojecticaro.poc_tax_service.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.myprojecticaro.poc_tax_service.application.port.StateRepositoryPort;
import com.myprojecticaro.poc_tax_service.domain.model.State;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;

@ExtendWith(MockitoExtension.class)
class StateServiceTest {

    @Mock
    private StateRepositoryPort stateRepositoryPort;

    @InjectMocks
    private StateService stateService;

    private StateEntity stateEntity;
    private State state;

    @BeforeEach
    void setUp() {
        stateEntity = new StateEntity(1L, "São Paulo", "SP");
        state = new State(1L, "São Paulo", "SP");
    }

    @Test
    void createState_ShouldSaveState_WhenCodeDoesNotExist() {
        when(stateRepositoryPort.existsByCode("SP")).thenReturn(false);
        when(stateRepositoryPort.save(any(StateEntity.class))).thenReturn(stateEntity);

        StateEntity createdState = stateService.createState("São Paulo", "SP");

        assertEquals("São Paulo", createdState.getName());
        assertEquals("SP", createdState.getCode());
        verify(stateRepositoryPort, times(1)).save(any(StateEntity.class));
    }

    @Test
    void createState_ShouldThrowException_WhenCodeAlreadyExists() {
        when(stateRepositoryPort.existsByCode("SP")).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            stateService.createState("São Paulo", "SP");
        });

        assertEquals("Já existe um estado com este código: SP", exception.getMessage());
        verify(stateRepositoryPort, never()).save(any(StateEntity.class));
    }

    @Test
    void deleteState_ShouldDelete_WhenStateExists() {
        when(stateRepositoryPort.existsById(1L)).thenReturn(true);

        stateService.deleteState(1L);

        verify(stateRepositoryPort, times(1)).deleteById(1L);
    }

    @Test
    void deleteState_ShouldThrowException_WhenStateDoesNotExist() {
        when(stateRepositoryPort.existsById(1L)).thenReturn(false);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            stateService.deleteState(1L);
        });

        assertEquals("Estado não encontrado com ID: 1", exception.getMessage());
        verify(stateRepositoryPort, never()).deleteById(1L);
    }

    @Test
    void getAllStates_ShouldReturnListOfStates() {
        when(stateRepositoryPort.findAll()).thenReturn(List.of(state));

        List<State> states = stateService.getAllStates();

        assertEquals(1, states.size());
        assertEquals("São Paulo", states.get(0).name());
        verify(stateRepositoryPort, times(1)).findAll();
    }
}
