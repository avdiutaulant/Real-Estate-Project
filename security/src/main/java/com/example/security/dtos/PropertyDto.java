package com.example.security.dtos;

import com.example.security.entities.Address;
import com.example.security.entities.Agent;
import com.example.security.entities.Status;
import com.example.security.entities.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {

    private int id;

    private Address address;

    private Type type;

    private double price;

    private double size;

    private int bedrooms;
    private int bathrooms;

    private String amentities;

    private String description;

    private Status status;


    private String agentName;

    private String images;
}
