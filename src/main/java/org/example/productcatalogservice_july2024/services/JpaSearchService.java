package org.example.productcatalogservice_july2024.services;

import org.example.productcatalogservice_july2024.dtos.SortParam;
import org.example.productcatalogservice_july2024.dtos.SortType;
import org.example.productcatalogservice_july2024.models.Product;
import org.example.productcatalogservice_july2024.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaSearchService implements ISearchService {

    @Autowired
    private ProductRepo productRepo;

    public Page<Product> searchProducts(String query, Integer pageNumber, Integer pageSize, List<SortParam> sortParamList) {
        //Sort sort = Sort.by("price").and(Sort.by("id").descending());
        Sort sort = null;
        if(!sortParamList.isEmpty()) {
            if(sortParamList.get(0).getSortType().equals(SortType.ASC))
               sort = Sort.by(sortParamList.get(0).getParamName());
                     //Sort.by("price")
            else
                sort = Sort.by(sortParamList.get(0).getParamName()).descending();

            for(int i=1;i<sortParamList.size();i++) {
                if(sortParamList.get(i).getSortType().equals(SortType.ASC))
                    sort.and(Sort.by(sortParamList.get(i).getParamName()));
                else
                    sort.and(Sort.by(sortParamList.get(i).getParamName()).descending());
            }
        }


      return productRepo.findProductByName(query, PageRequest.of(pageNumber,pageSize,sort));
    }
}
