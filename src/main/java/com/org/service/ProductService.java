package com.org.service;

import com.org.model.Products;
import com.org.model.response.ProductsResponse;
import com.org.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductsResponse getAllProducts()
    {
        List<Products> products = productRepository.findAll();
        log.info("products :: {}", products);
        ProductsResponse productsResponse = new ProductsResponse();
        productsResponse.setData(products);
        return productsResponse;
    }
}
