package org.example.productcatalogservice_sept2024.controllers;

import org.example.productcatalogservice_sept2024.models.Product;
import org.example.productcatalogservice_sept2024.services.IProductService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class StorageProductServiceStub implements IProductService {

    Map<String,Product> productMap;

    public StorageProductServiceStub() {
        productMap = new HashMap<>();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
