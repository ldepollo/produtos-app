package com.letscode.produtosapp.controller;

import com.letscode.produtosapp.domain.Product;
import com.letscode.produtosapp.dto.ProductRequestDto;
import com.letscode.produtosapp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{sku}")
    public ResponseEntity<Product> getProductBySku(@PathVariable("sku") String sku) {
        Product product = productService.getProductBySku(sku);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = productService.addProduct(productRequestDto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity<Void> deleteProductBySku(@PathVariable("sku") String sku) {
        productService.deleteProduct(sku);
        return ResponseEntity.ok().build();
    }
}
