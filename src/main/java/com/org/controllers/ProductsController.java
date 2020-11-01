/**
 *
 */
package com.org.controllers;

import com.org.model.response.ProductsResponse;
import com.org.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi
 *
 */
@RestController
@Slf4j
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/welcome")
    @ApiOperation(value = "Welcome microservice")
    public String welcomeNotes()
    {
        log.info("Inside welcome");
        return "Welcome to Java Microservices";
    }

    @GetMapping(value = "/products")
    @ApiOperation(value = "should find all products",
                    notes = "Returns list of products ")
    public ProductsResponse fetchAllProducts() {
        log.info("Inside fetching products");
        return productService.getAllProducts();
    }
}
