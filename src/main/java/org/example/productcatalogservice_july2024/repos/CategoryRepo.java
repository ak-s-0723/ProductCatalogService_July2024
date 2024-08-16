package org.example.productcatalogservice_july2024.repos;

import org.example.productcatalogservice_july2024.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    Optional<Category> findById(Long id);
}
