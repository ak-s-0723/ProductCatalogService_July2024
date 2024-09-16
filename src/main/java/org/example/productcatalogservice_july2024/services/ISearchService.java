package org.example.productcatalogservice_july2024.services;

import org.example.productcatalogservice_july2024.dtos.SortParam;
import org.example.productcatalogservice_july2024.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {
     Page<Product> searchProducts(String query, Integer pageNumber, Integer pageSize,List<SortParam> sortParamList);
}
