package org.example.productcatalogservice_sept2024.controllers;

import org.example.productcatalogservice_sept2024.dtos.CategoryDto;
import org.example.productcatalogservice_sept2024.dtos.ProductDto;
import org.example.productcatalogservice_sept2024.models.Product;
import org.example.productcatalogservice_sept2024.services.IProductService;
import org.example.productcatalogservice_sept2024.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

//    public ProductController(IProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return null;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId)
    {
        try {
            if (productId < 1) {
                throw new RuntimeException("Product not found");
            }
            Product product = productService.getProductById(productId);
            if (product == null) return null;
            return new ResponseEntity<>(from(product), HttpStatus.OK);
        }catch (RuntimeException exception) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto product) {
        return null;
    }

    private ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setAmount(product.getAmount());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }
}
