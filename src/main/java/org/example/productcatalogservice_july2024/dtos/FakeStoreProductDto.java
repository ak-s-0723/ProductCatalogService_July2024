package org.example.productcatalogservice_july2024.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class FakeStoreProductDto implements Serializable {
    private Long id;

    private String title;

    private String description;

    private String category;

    private String image;

    private Double price;
}
