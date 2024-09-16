package org.example.productcatalogservice_july2024.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortParam {
    private String paramName;
    private SortType sortType;
}
