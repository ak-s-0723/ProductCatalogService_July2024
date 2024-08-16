package org.example.productcatalogservice_july2024.repos;

import org.example.productcatalogservice_july2024.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    //Product save(Product product);

    //Optional<Product> findById(Long id);

    List<Product> findProductByPriceBetween(Double low,Double high);

    //List<Product> findAllByIsPrime(Boolean value);
    //List<Product> findAllByIsPrimeTrue();

    //List<Product> findAllOrderByPriceDesc(); WRONG SYNTAX
    List<Product> findAllByOrderByPriceDesc();

    @Query("SELECT p.name from Product p WHERE p.id=?1")
    String findProductNameFromProductId(Long productId);

    @Query("SELECT c.name FROM Category c join Product p on c.id=p.category.id where p.id=:productId")
    String findCategoryNameFromProductId(Long productId);


}


//
//PostionalAssociiation
//NamedAssociation
//
//        void foo(int a,int b) {
//        }
//
//        foo(1,2) -pos
//        foo(a:1,b:2) -name
