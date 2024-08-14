package org.example.productcatalogservice_july2024.TableInheritanceExamples.TablesPerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_instructor")
public class Instructor extends User {
    private String company;

}
