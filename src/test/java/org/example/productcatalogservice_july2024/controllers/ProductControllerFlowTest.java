package org.example.productcatalogservice_july2024.controllers;

import org.example.productcatalogservice_july2024.dtos.ProductDto;
import org.example.productcatalogservice_july2024.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductControllerFlowTest {

    @Autowired
    private ProductController productController;

    //@Test
    public void Test_Create_Replace_GetProduct_WithStub_RunSuccessfully() {
        //Arrange
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("Iphone 15");

        //Act
        ProductDto response = productController.createProduct(productDto);
        ProductDto productDtoR = productController
                .getProductById(1L);
        productDto.setName("Iphone 16");

        ProductDto replacedProduct = productController.replaceProduct(1L,productDto);
        ProductDto productDtoR2 = productController
                .getProductById(1L);

        //Assert
        assertEquals("Iphone 15",productDtoR.getName());
        assertEquals("Iphone 16",productDtoR2.getName());
    }
}
