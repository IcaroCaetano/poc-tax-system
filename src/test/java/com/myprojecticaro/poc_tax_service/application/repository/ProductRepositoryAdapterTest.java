package com.myprojecticaro.poc_tax_service.application.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.myprojecticaro.poc_tax_service.domain.model.Product;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.ProductRepositoryAdapter;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.SpringDataProductRepository;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryAdapterTest {

    @Mock
    private SpringDataProductRepository repository;

    @InjectMocks
    private ProductRepositoryAdapter productRepositoryAdapter;

    private Product product;
    private ProductEntity productEntity;

    @BeforeEach
    void setUp() {
        product = new Product(1L, "Laptop", "Electronics", "Dell", "SN456");
        productEntity = new ProductEntity(1L, "Laptop", "Electronics", "Dell", "SN456");
    }

    @Test
    void save_ShouldPersistProductEntity() {
        when(repository.save(any(ProductEntity.class))).thenReturn(productEntity);
        
        ProductEntity savedEntity = productRepositoryAdapter.save(product);
        
        assertNotNull(savedEntity);
        assertEquals(productEntity.getId(), savedEntity.getId());
        verify(repository, times(1)).save(any(ProductEntity.class));
    }

    @Test
    void findById_ShouldReturnProductEntity() {
        when(repository.findById(1L)).thenReturn(Optional.of(productEntity));
        
        Optional<ProductEntity> foundEntity = productRepositoryAdapter.findById(1L);
        
        assertTrue(foundEntity.isPresent());
        assertEquals(productEntity.getId(), foundEntity.get().getId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void findAll_ShouldReturnListOfProductEntities() {
        when(repository.findAll()).thenReturn(List.of(productEntity));
        
        List<ProductEntity> products = productRepositoryAdapter.findAll();
        
        assertEquals(1, products.size());
        assertEquals(productEntity.getId(), products.get(0).getId());
        verify(repository, times(1)).findAll();
    }

    @Test
    void deleteById_ShouldRemoveProductEntity() {
        doNothing().when(repository).deleteById(1L);
        
        productRepositoryAdapter.deleteById(1L);
        
        verify(repository, times(1)).deleteById(1L);
    }
}
