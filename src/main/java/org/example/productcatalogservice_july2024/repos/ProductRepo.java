package org.example.productcatalogservice_july2024.repos;

import org.example.productcatalogservice_july2024.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    //Product save(Product product);

    //Optional<Product> findById(Long id);
}
