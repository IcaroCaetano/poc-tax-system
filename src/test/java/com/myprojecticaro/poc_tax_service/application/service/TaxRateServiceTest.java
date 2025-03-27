package com.myprojecticaro.poc_tax_service.application.service; 

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

import com.myprojecticaro.poc_tax_service.application.port.TaxRateRepositoryPort;
import com.myprojecticaro.poc_tax_service.domain.model.TaxRate;

@ExtendWith(MockitoExtension.class)
class TaxRateServiceTest {

    @Mock
    private TaxRateRepositoryPort taxRateRepository;

    @InjectMocks
    private TaxRateService taxRateService;

    private TaxRate taxRate;

    @BeforeEach
    void setUp() {
        taxRate = new TaxRate(1L, 2024, 10L, 20L, BigDecimal.valueOf(15.5));
    }

    @Test
    void createTaxRate_ShouldSaveTaxRate() {
        when(taxRateRepository.save(taxRate)).thenReturn(taxRate);
        
        TaxRate savedTaxRate = taxRateService.createTaxRate(taxRate);
        
        assertNotNull(savedTaxRate);
        assertEquals(1L, savedTaxRate.id());
        verify(taxRateRepository, times(1)).save(taxRate);
    }

    @Test
    void getTaxRateById_ShouldReturnTaxRate() {
        when(taxRateRepository.findById(1L)).thenReturn(Optional.of(taxRate));

        Optional<TaxRate> retrievedTaxRate = taxRateService.getTaxRateById(1L);

        assertTrue(retrievedTaxRate.isPresent());
        assertEquals(1L, retrievedTaxRate.get().id());
        verify(taxRateRepository, times(1)).findById(1L);
    }

    @Test
    void getAllTaxRates_ShouldReturnListOfTaxRates() {
        when(taxRateRepository.findAll()).thenReturn(List.of(taxRate));

        List<TaxRate> taxRates = taxRateService.getAllTaxRates();

        assertEquals(1, taxRates.size());
        assertEquals(1L, taxRates.get(0).id());
        verify(taxRateRepository, times(1)).findAll();
    }

    @Test
    void deleteTaxRate_ShouldDeleteById() {
        when(taxRateRepository.findById(1L)).thenReturn(Optional.of(taxRate));
        
        taxRateService.deleteTaxRate(1L);
        
        verify(taxRateRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteTaxRate_ShouldThrowExceptionWhenNotFound() {
        when(taxRateRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taxRateService.deleteTaxRate(1L);
        });

        assertEquals("Tax rate not found", exception.getMessage());
        verify(taxRateRepository, never()).deleteById(anyLong());
    }
}