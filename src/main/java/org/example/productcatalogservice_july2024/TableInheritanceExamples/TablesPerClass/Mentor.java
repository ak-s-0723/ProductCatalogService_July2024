package org.example.productcatalogservice_july2024.TableInheritanceExamples.TablesPerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class Mentor extends User {
    private Integer numberOfHours;
}
