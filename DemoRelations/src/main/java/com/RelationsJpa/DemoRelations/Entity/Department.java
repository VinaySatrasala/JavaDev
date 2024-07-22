package com.RelationsJpa.DemoRelations.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Department {
    @Id
    private int id;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
