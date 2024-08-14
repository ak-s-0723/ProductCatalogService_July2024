package org.example.productcatalogservice_july2024.TableInheritanceExamples.MappedSuperClaass;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class User {

    @Id
    private Long id;

    private String name;
}
