package org.example.productcatalogservice_july2024.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_july2024.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    public void testQueries() {

//        List<Product> productList = productRepo.findAllByOrderByPriceDesc();
//        for(Product product : productList) {
//            System.out.println(product.getPrice());
//        }

        String val = productRepo.findCategoryNameFromProductId(6L);
        System.out.println(val);
    }

}