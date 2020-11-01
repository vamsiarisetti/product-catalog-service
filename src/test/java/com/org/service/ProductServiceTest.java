package com.org.service;

import com.org.model.Products;
import com.org.model.response.ProductsResponse;
import com.org.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void shouldReturnProducts()
    {
        Products products = new Products(1, "product1", "prod-1234-isbn", true, LocalDateTime.now());
        Products products1 = new Products(2, "product2", "prod-3214-isbn", false, LocalDateTime.now());
        ProductsResponse productsResponse = new ProductsResponse();
        productsResponse.setData(Collections.singletonList(products));
        when(productRepository.findAll())
                .thenReturn(Arrays.asList(products, products1, new Products()));
        ProductsResponse allProducts = productService.getAllProducts();
        assertNotNull(allProducts);
        assertEquals(3, allProducts.getData().size());
        assertEquals("product1", allProducts.getData().get(0).getProduct());
        assertEquals("prod-1234-isbn", allProducts.getData().get(0).getIsbn());
        assertTrue(allProducts.getData().get(0).isAvailable());

        assertEquals("product2", allProducts.getData().get(1).getProduct());
        assertEquals("prod-3214-isbn", allProducts.getData().get(1).getIsbn());
        assertFalse(allProducts.getData().get(1).isAvailable());
    }
}