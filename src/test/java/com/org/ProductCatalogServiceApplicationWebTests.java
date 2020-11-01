package com.org;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ProductCatalogServiceApplication.class)
//@WebAppConfiguration
public class ProductCatalogServiceApplicationWebTests extends ProductCatalogServiceApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    /*@Test
    public void testProducts() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
//                .andExpect(jsonPath("$.data[0].product").value("product1"));
                .andReturn();
    }*/
//    public MockMvc getMockMvc() {return mockMvc; }
}
