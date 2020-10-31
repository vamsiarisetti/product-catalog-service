package com.org.controllers;

import com.org.model.Products;
import com.org.model.response.ProductsResponse;
import com.org.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@WebMvcTest(secure = false)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        TestConfiguration.class,
        ProductsController.class})
public class ProductsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void shouldReturnWelcomeNotes() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/welcome")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[]"))
        .andExpect(status().isOk())
        .andReturn();
    }
    @Test
    public void shouldReturnAllProducts() throws Exception {
        Products products = new Products(1, "product1", "prod-1234-isbn", true, LocalDateTime.now());
        ProductsResponse productsResponse = new ProductsResponse();
        productsResponse.setData(Collections.singletonList(products));
        when(productService.getAllProducts())
                .thenReturn(productsResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/products")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[]"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data[0].product", is("product1")))
        .andReturn();
    }
}
