package org.example.productcatalogservice_july2024.services;

import org.example.productcatalogservice_july2024.models.Product;
import org.example.productcatalogservice_july2024.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sps")
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);

        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        }

        return null;
    }

    @Override
    public Product createProduct(Product product) {
       return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Product product, Long id) {
        return null;
    }
}
