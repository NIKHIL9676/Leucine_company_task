package com.leucine.entity;

import jakarta.persistence.*;

@Entity
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    // Getters, Setters, Constructors, and toString()
}
