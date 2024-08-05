package org.example.productcatalogservice_july2024.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel {
    private String name;

    private String description;

    private Double price;

    private String imageUrl;

    private Category category;
}
