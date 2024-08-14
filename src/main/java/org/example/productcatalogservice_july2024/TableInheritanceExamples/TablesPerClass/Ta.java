package org.example.productcatalogservice_july2024.TableInheritanceExamples.TablesPerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_ta")
public class Ta extends User{
    private Double ratings;
}
