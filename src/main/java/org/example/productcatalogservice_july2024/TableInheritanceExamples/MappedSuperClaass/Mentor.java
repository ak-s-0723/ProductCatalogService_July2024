package org.example.productcatalogservice_july2024.TableInheritanceExamples.MappedSuperClaass;

import jakarta.persistence.Entity;

@Entity(name="msc_mentor")
public class Mentor extends User {
    private Integer numberOfHours;
}
