package org.example.productcatalogservice_july2024.dtos;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_july2024.models.BaseModel;

@Setter
@Getter
@Entity
public class Role extends BaseModel {

    private String value;
}

//m         1
//user    role
// 1      m
//
//m   :   m
