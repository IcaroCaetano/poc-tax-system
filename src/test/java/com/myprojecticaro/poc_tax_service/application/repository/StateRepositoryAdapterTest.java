package com.myprojecticaro.poc_tax_service.application.repository;

import com.myprojecticaro.poc_tax_service.domain.model.State;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.SpringDataStateRepository;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.StateRepositoryAdapter;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StateRepositoryAdapterTest {

    @Mock
    private SpringDataStateRepository repository;

    @InjectMocks
    private StateRepositoryAdapter stateRepositoryAdapter;

    private StateEntity stateEntity;
    private State state;

    @BeforeEach
    void setUp() {
        stateEntity = new StateEntity(1L, "SP", "São Paulo");
        state = new State(1L, "SP", "São Paulo");
    }

    @Test
    void testSave() {
        when(repository.save(stateEntity)).thenReturn(stateEntity);

        StateEntity result = stateRepositoryAdapter.save(stateEntity);
        
        assertNotNull(result);
        assertEquals(stateEntity.getId(), result.getId());
        verify(repository, times(1)).save(stateEntity);
    }

    @Test
    void testDeleteById() {
        stateRepositoryAdapter.deleteById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void testExistsById() {
        when(repository.existsById(1L)).thenReturn(true);

        boolean exists = stateRepositoryAdapter.existsById(1L);

        assertTrue(exists);
        verify(repository, times(1)).existsById(1L);
    }

    @Test
    void testExistsByCode() {
        when(repository.existsByCode("SP")).thenReturn(true);

        boolean exists = stateRepositoryAdapter.existsByCode("SP");

        assertTrue(exists);
        verify(repository, times(1)).existsByCode("SP");
    }

    @Test
    void testFindById() {
        when(repository.findById(1L)).thenReturn(Optional.of(stateEntity));

        Optional<State> result = stateRepositoryAdapter.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(state.id(), result.get().id());
        assertEquals(state.code(), result.get().code());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(List.of(stateEntity));

        List<State> result = stateRepositoryAdapter.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(state.id(), result.get(0).id());
        assertEquals(state.code(), result.get(0).code());
        verify(repository, times(1)).findAll();
    }
}