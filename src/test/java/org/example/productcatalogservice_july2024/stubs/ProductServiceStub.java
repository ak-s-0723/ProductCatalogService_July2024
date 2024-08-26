package org.example.productcatalogservice_july2024.stubs;

import org.example.productcatalogservice_july2024.models.Product;
import org.example.productcatalogservice_july2024.services.IProductService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class ProductServiceStub implements IProductService {

    Map<Long,Product> productMap;

    public ProductServiceStub() {
        this.productMap = new HashMap<>();
    }

    @Override
    public Product getProductById(Long id) {
        return productMap.get(id);
    }

    @Override
    public Product createProduct(Product product) {
        productMap.put(product.getId(),product);
        return productMap.get(product.getId());
    }

    @Override
    public List<Product> getAllProducts() {
        //return productMap.values();
        return null;
    }

    @Override
    public Product replaceProduct(Product product, Long id) {
       productMap.put(id,product);
       return productMap.get(id);
    }
}
