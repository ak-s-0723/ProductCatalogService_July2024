package org.example.productcatalogservice_july2024.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_july2024.models.Category;
import org.example.productcatalogservice_july2024.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void demonstrateLoading() {

        Category c = categoryRepo.findById(2L).get();
        categoryRepo.save(c);

        for(Product product : c.getProducts()) {
            System.out.println(product.getDescription());
        }

    }


    @Test
    @Transactional
    public void demonstrateFetchModeFetchType() {
        Category c = categoryRepo.findById(2L).get();
        for(Product product : c.getProducts()) {
            System.out.println(product.getDescription());
        }
    }

    @Test
    @Transactional
    public void nPlusOneProblem() {
        List<Category> categoryList = categoryRepo.findAll();
        for(Category category : categoryList) {
            if(!category.getProducts().isEmpty()) {
                List<Product> products = category.getProducts();
                for(Product product : products) {
                   System.out.println(product.getDescription());
               }
            }
        }
    }
}


//1 category = parent ->  n children
//
//        select * from p where (select * from category .....)