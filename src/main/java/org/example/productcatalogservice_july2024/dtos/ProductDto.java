package org.example.productcatalogservice_july2024.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_july2024.models.Category;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private String imageUrl;

    private CategoryDto category;
}
