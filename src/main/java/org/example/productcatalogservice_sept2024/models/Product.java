package org.example.productcatalogservice_sept2024.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel {
    private String title;

    private String description;

    private String imageUrl;

    private Double amount;

    private Category category;
}
