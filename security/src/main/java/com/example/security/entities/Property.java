package com.example.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.STRING)
    private Type type;

    private double price;

    private double size;

    private int bedrooms;
    private int bathrooms;

    private String amentities;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;


   @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
   @JoinColumn(name = "agent_id")
    private Agent agent;

    private String images;

    private LocalDate createdAt;



}
