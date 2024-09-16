package org.example.productcatalogservice_july2024.controllers;

import org.example.productcatalogservice_july2024.dtos.CategoryDto;
import org.example.productcatalogservice_july2024.dtos.ProductDto;
import org.example.productcatalogservice_july2024.dtos.SearchRequestDto;
import org.example.productcatalogservice_july2024.models.Product;
import org.example.productcatalogservice_july2024.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/search")
@RestController
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {
       Page<Product> products = searchService.searchProducts(searchRequestDto.getQuery(),searchRequestDto.getPageNumber(), searchRequestDto.getPageLimit(),searchRequestDto.getSortParamList());
       return products;
    }
}
