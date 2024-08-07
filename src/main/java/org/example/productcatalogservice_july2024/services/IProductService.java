package org.example.productcatalogservice_july2024.services;

import org.example.productcatalogservice_july2024.models.Product;

import java.util.List;

public interface IProductService {

    public Product getProductById(Long id);

    public Product createProduct(Product product);

    public List<Product> getAllProducts();
}
