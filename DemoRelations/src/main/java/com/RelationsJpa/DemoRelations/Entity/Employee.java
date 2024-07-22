package com.RelationsJpa.DemoRelations.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    private Long empId;
    private String empName;

    @OneToOne()
    @JoinColumn(name = "address_id")
    public Address address;

    @ManyToOne()
    public Department department;
}
