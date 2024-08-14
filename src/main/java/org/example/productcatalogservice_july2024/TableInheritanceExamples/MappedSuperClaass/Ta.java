package org.example.productcatalogservice_july2024.TableInheritanceExamples.MappedSuperClaass;

import jakarta.persistence.Entity;

@Entity(name="msc_ta")
public class Ta extends User {
    private Double ratings;
}
