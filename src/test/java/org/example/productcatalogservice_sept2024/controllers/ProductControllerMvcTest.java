package org.example.productcatalogservice_sept2024.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogservice_sept2024.dtos.ProductDto;
import org.example.productcatalogservice_sept2024.models.Product;
import org.example.productcatalogservice_sept2024.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;
    //object <-> json <-> string


    @Test
    public void TestGetAllProducts_RunsSuccessfully() throws Exception {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Iphone 16");
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productService.getAllProducts()).thenReturn(productList);

       mockMvc.perform(get("/products"))
               .andExpect(status().isOk())
               .andExpect(content().string(objectMapper.writeValueAsString(productList)));
    }


    @Test
    public void TestCreateProduct_RunsSuccessfully() throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setId(2L);
        productDto.setTitle("MacBook Pro");

        Product product = new Product();
        product.setId(2L);
        product.setTitle("MacBook Pro");

        when(productService.createProduct(any(Product.class))).thenReturn(product);


        mockMvc.perform(post("/products")
                        .content(objectMapper.writeValueAsString(productDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(productDto)))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.title").value("MacBook Pro"));
    }
}


//{
//    "id" : 2, "title" : "MacBook Pro"
//}

//$.title
//$.id
//$.length()