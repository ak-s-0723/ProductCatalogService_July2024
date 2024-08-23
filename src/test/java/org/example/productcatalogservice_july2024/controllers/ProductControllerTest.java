package org.example.productcatalogservice_july2024.controllers;


import org.example.productcatalogservice_july2024.dtos.ProductDto;
import org.example.productcatalogservice_july2024.models.Category;
import org.example.productcatalogservice_july2024.models.Product;
import org.example.productcatalogservice_july2024.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService productService;

    @Test
    public void Test_GetProductById_WithValidId_ReturnsProductSuccessfully() {
        //Arrange
        Long productId = 9999999999L;
        Product product = new Product();
        product.setId(productId);
        product.setName("Iphone12");
        product.setPrice(100000D);
        Category category = new Category();
        category.setId(2L);
        category.setName("iPHONES");
        product.setCategory(category);
       when(productService.getProductById(productId)).thenReturn(product);

        //Act
        ResponseEntity<ProductDto> response = productController.getProductById(productId);

        //Assert
        assertNotNull(response);
        assertEquals(response.getBody().getName(),"Iphone12");
        assertEquals(response.getBody().getId(),productId);
        verify(productService,times(1)).getProductById(productId);
    }

    @Test
    public void Test_GetProductById_WithInvalidId_ThrowsIllegalArgumentException() {
        //Act and Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> productController.getProductById(-1L));

        assertEquals("Are you crazy ?",exception.getMessage());

        verify(productService,times(0)).getProductById(-1L);
    }

    @Test
    public void Test_GetProductById_ProductServiceThrowsException() {
        //Arrange
        Long productId = 2L;
        when(productService.getProductById(productId)).
                thenThrow(new RuntimeException("something went bad !!"));

        assertThrows(Exception.class,() -> productController.getProductById(productId));
    }

    @Test
    public void Test_CreateProduct_ValidPayload_RunsSuccessfully() {
       //Arrange
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("Iphone12");
        productDto.setPrice(100000D);

        Product product = new Product();
        product.setId(1L);
        product.setName("Iphone12");
        product.setPrice(100000D);
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        //Act
        ProductDto response = productController.createProduct(productDto);

        //Assert
        assertNotNull(response);
        assertEquals("Iphone12",response.getName());
    }
}