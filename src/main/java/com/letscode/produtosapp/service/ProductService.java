package com.letscode.produtosapp.service;

import com.letscode.produtosapp.domain.Product;
import com.letscode.produtosapp.dto.ProductRequestDto;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductBySku(String sku) {
        return productRepository.findBySku(sku).orElseThrow(() -> {
            throw new RuntimeException("There is no product with this sku");
        });
    }

    public Product addProduct(ProductRequestDto productRequestDto) {
        if(productRepository.existsBySku(productRequestDto.getSku())) {
            throw new RuntimeException("There is already a product with this sku");
        }

        Product product = new Product(productRequestDto.getSku(),
                productRequestDto.getName(),
                productRequestDto.getValue());

        productRepository.save(product);
        return product;
    }

    public void deleteProduct(String sku) {
        Product product = productRepository.findBySku(sku).orElseThrow(() -> {
            throw new RuntimeException("There is no product with this sku");
        });

        productRepository.delete(product);
    }
}
