package org.example.productcatalogservice_sept2024.controllers;

import org.example.productcatalogservice_sept2024.dtos.ProductDto;
import org.example.productcatalogservice_sept2024.models.Product;
import org.example.productcatalogservice_sept2024.services.IProductService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

         @Autowired
         private ProductController productController;


         @MockBean
         private IProductService productService;


         @Captor
         private ArgumentCaptor<Long> idCaptor;


         // testName_When_Then

         @Test
         public void testGetProductById_WhenValidIdIsPassed_ReturnsProductSuccessfully() {

             //Arrange
             Product product = new Product();
             product.setAmount(1000D);
             product.setTitle("Iphone 16");
             product.setDescription("Fastest Iphone");
             product.setIsPrimeSpecific(true);
             product.setId(1L);
             when(productService.getProductById(any(Long.class))).thenReturn(product);

             //Act
             ResponseEntity<ProductDto> responseEntity =  productController.getProductById(1L);

             //Assert
             assertNotNull(responseEntity);
             assertNotNull(responseEntity.getBody());
             assertEquals(1000D,responseEntity.getBody().getAmount());
             assertEquals("Iphone 16",responseEntity.getBody().getTitle());

             verify(productService).getProductById(idCaptor.capture());
             assertEquals(1L,idCaptor.getValue());
         }


         @Test
         public void testGetProductById_WhenInvalidIdIsPassed_ResultsInRuntimeException() {
                 RuntimeException ex = assertThrows(RuntimeException.class,
                         () ->  productController.getProductById(0L));

                 assertEquals("Something very bad",ex.getMessage());
         }

}

