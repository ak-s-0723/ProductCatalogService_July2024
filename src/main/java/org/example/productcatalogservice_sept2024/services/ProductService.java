package org.example.productcatalogservice_sept2024.services;

import org.example.productcatalogservice_sept2024.clients.FakeStoreApiClient;
import org.example.productcatalogservice_sept2024.dtos.FakeStoreProductDto;
import org.example.productcatalogservice_sept2024.models.Category;
import org.example.productcatalogservice_sept2024.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class ProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;


    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
       RestTemplate restTemplate =  restTemplateBuilder.build();
       FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDto[].class).getBody();
       for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
           products.add(from(fakeStoreProductDto));
       }

        return products;
    }

    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreApiClient.getProductById(id);
        if(fakeStoreProductDto!=null) {
            return from(fakeStoreProductDto);
        }

        return null;
    }

    //Homework
    public Product createProduct(Product product) {
        return product;
    }

    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = from(product);
      FakeStoreProductDto fakeStoreProductDtoResponse =
              requestForEntity("https://fakestoreapi.com/products/{id}",HttpMethod.PUT,fakeStoreProductDto, FakeStoreProductDto.class,id).getBody();

      return from(fakeStoreProductDtoResponse);
    }

    private <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setAmount(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getAmount());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        if(product.getCategory() != null) {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }

        return fakeStoreProductDto;
    }
}
