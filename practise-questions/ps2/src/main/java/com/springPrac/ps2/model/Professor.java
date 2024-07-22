package com.springPrac.ps2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Other professor attributes like email, department, etc.

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Course> courses;

    // Constructors, getters, and setters
}
