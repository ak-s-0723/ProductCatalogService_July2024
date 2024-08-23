package org.example.productcatalogservice_july2024.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogservice_july2024.models.Product;
import org.example.productcatalogservice_july2024.services.IProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;


    //object <-> json <-> string
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void Test_GetAllProductsAPI_TestsStatusOnly() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    public void Test_GetAllProductsAPI_TestsContentAndStatus() throws Exception {

        //Arrange
        Product product1 = new Product();
        product1.setName("Iphone12");
        Product product2 = new Product();
        product2.setName("Iphone15");
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        when(productService.getAllProducts()).thenReturn(productList);

        //Act and Assert
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(productList)));
    }
}
