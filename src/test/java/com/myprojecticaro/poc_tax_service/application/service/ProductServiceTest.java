package com.myprojecticaro.poc_tax_service.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.myprojecticaro.poc_tax_service.application.port.ProductRepositoryPort;
import com.myprojecticaro.poc_tax_service.domain.model.Product;
import com.myprojecticaro.poc_tax_service.infrastructure.repository.product.entity.ProductEntity;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepositoryPort productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;
    private ProductEntity productEntity;

    @BeforeEach
    void setUp() {
        product = new Product(1L, "Television", "Household appliance", "Samsung", "SN123");
        productEntity = new ProductEntity(1L, "Television", "household appliance", "Samsung", "SN123");
    }

    @Test
    void createProduct_ShouldSaveProduct() {
        productService.createProduct(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void getAllProducts_ShouldReturnListOfProducts() {
        when(productRepository.findAll()).thenReturn(List.of(productEntity));

        List<Product> products = productService.getAllProducts();

        assertEquals(1, products.size());
        assertEquals("Television", products.get(0).name());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void deleteProduct_ShouldDeleteById() {
        Long productId = 1L;
        productService.deleteProduct(productId);
        verify(productRepository, times(1)).deleteById(productId);
    }
}