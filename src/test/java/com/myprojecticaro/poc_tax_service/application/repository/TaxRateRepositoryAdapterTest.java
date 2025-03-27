package com.myprojecticaro.poc_tax_service.application.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate.TaxRateRepositoryAdapter;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate.SpringDataTaxRateRepository;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.taxrate.entity.TaxRateEntity;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.SpringDataProductRepository;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.SpringDataStateRepository;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;
import com.myprojecticaro.poc_tax_service.domain.model.TaxRate;

@ExtendWith(MockitoExtension.class)
class TaxRateRepositoryAdapterTest {

    @Mock
    private SpringDataTaxRateRepository taxRateRepository;
    
    @Mock
    private SpringDataProductRepository productRepository;
    
    @Mock
    private SpringDataStateRepository stateRepository;
    
    @InjectMocks
    private TaxRateRepositoryAdapter taxRateRepositoryAdapter;
    
    private ProductEntity product;
    private StateEntity state;
    private TaxRateEntity taxRateEntity;
    private TaxRate taxRate;

    @BeforeEach
    void setUp() {
        product = new ProductEntity(1L, "Television", "Electronics", "Samsung", "SN123");
        state = new StateEntity(1L, "California", "CA");
        taxRateEntity = new TaxRateEntity(1L, product, state, 2024, new BigDecimal("7.5"));
        taxRate = new TaxRate(1L, 2024, product.getId(), state.getId(), new BigDecimal("7.5"));
    }

    @Test
    void save_ShouldPersistTaxRate() {
        when(productRepository.findById(taxRate.productId())).thenReturn(Optional.of(product));
        when(stateRepository.findById(taxRate.stateId())).thenReturn(Optional.of(state));
        when(taxRateRepository.save(any(TaxRateEntity.class))).thenReturn(taxRateEntity);
        
        TaxRate savedTaxRate = taxRateRepositoryAdapter.save(taxRate);
        
        assertNotNull(savedTaxRate);
        assertEquals(taxRate.id(), savedTaxRate.id());
        verify(taxRateRepository, times(1)).save(any(TaxRateEntity.class));
    }
    
    @Test
    void findById_ShouldReturnTaxRate() {
        when(taxRateRepository.findById(1L)).thenReturn(Optional.of(taxRateEntity));
        
        Optional<TaxRate> foundTaxRate = taxRateRepositoryAdapter.findById(1L);
        
        assertTrue(foundTaxRate.isPresent());
        assertEquals(2024, foundTaxRate.get().fiscalYear());
        verify(taxRateRepository, times(1)).findById(1L);
    }
    
    @Test
    void findAll_ShouldReturnListOfTaxRates() {
        when(taxRateRepository.findAll()).thenReturn(List.of(taxRateEntity));
        
        List<TaxRate> taxRates = taxRateRepositoryAdapter.findAll();
        
        assertEquals(1, taxRates.size());
        assertEquals(2024, taxRates.get(0).fiscalYear());
        verify(taxRateRepository, times(1)).findAll();
    }
    
    @Test
    void deleteById_ShouldDeleteTaxRate() {
        taxRateRepositoryAdapter.deleteById(1L);
        verify(taxRateRepository, times(1)).deleteById(1L);
    }
}