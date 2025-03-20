package com.myprojecticaro.poc_tax_service.infrastructure.controller;
import com.myprojecticaro.poc_tax_service.application.request.dto.ProductRequestDTO;
import com.myprojecticaro.poc_tax_service.application.service.ProductService;
import com.myprojecticaro.poc_tax_service.domain.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        productService.createProduct(productRequestDTO);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(204).build();
    }
}