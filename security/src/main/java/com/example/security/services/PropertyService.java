package com.example.security.services;

import com.example.security.entities.Property;

import java.util.List;

public interface PropertyService {

    List<Property> findAll();

    Property findById(int id);

    Property save (Property property, int id);

    void deleteById(int id);

    Property update(Property property, int id);

    Property changeAgent(int propertyId, int id);
}
