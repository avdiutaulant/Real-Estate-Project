package com.example.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agent")
public class Agent {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private String name;
    private String contactInfo;
    private String email;

    @Enumerated(EnumType.STRING)
    private Rating rating;


   @OneToMany(mappedBy = "agent",
   fetch = FetchType.EAGER,
   cascade = CascadeType.ALL)
    private List<Property> property;



}
