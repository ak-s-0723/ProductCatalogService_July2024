package org.example.productcatalogservice_july2024.controllers;

import org.example.productcatalogservice_july2024.dtos.CategoryDto;
import org.example.productcatalogservice_july2024.dtos.ProductDto;
import org.example.productcatalogservice_july2024.models.Category;
import org.example.productcatalogservice_july2024.models.Product;
import org.example.productcatalogservice_july2024.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return null;
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable("id") Long productId) {
       Product product = productService.getProductById(productId);
       return getProductDto(product);
    }


    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto product)
    {
        return null;
    }

    private ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setDescription(product.getDescription());
        if(product.getCategory() != null) {
            CategoryDto category = new CategoryDto();
            category.setId(product.getCategory().getId());
            category.setName(product.getCategory().getName());
            productDto.setCategory(category);
        }
        return productDto;
    }
}
