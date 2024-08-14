package org.example.productcatalogservice_july2024.TableInheritanceExamples.MappedSuperClaass;

import jakarta.persistence.Entity;

@Entity(name="msc_instructor")
public class Instructor extends User {
    private String company;

}
