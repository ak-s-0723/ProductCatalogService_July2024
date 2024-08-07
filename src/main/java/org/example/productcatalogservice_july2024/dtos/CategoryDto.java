package org.example.productcatalogservice_july2024.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_july2024.models.Product;

import java.util.List;

@Setter
@Getter
public class CategoryDto {
    private Long id;

    private String name;

    private String description;
}
