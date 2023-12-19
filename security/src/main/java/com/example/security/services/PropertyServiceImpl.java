package com.example.security.services;

import com.example.security.entities.Agent;
import com.example.security.entities.Property;
import com.example.security.mappers.PropertyMapper;
import com.example.security.repositories.AgentRepository;
import com.example.security.repositories.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService{

    private final PropertyMapper propertyMapper;
    private final AgentRepository agentRepository;
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyMapper propertyMapper, AgentRepository agentRepository, PropertyRepository propertyRepository) {
        this.propertyMapper = propertyMapper;
        this.agentRepository = agentRepository;
        this.propertyRepository = propertyRepository;
    }


    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public Property findById(int id) {
        Optional<Property> result = propertyRepository.findById(id);

        Property property = null;

        if (result.isPresent()){
property = result.get();
        } else {
throw new RuntimeException("Did not find employee id " + id);
        }

        return property;
    }

    @Override
    public Property save(Property property,int agentId) {

//        Optional<Agent> result = agentRepository.findById(agentId);
//
//        Agent agent = null;
//
//        if (result.isPresent()){
//            agent = result.get();
//        } else {
//            throw new RuntimeException("Did not find agent id " + agentId);
//        }

        Agent agent = agentRepository.findById(agentId).orElseThrow(()-> new EntityNotFoundException("Agent not found with id " + agentId));


        property.setAgent(agent);
        property.setCreatedAt(LocalDate.now());
        return propertyRepository.save(property);
    }

    @Override
    public void deleteById(int id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public Property update(Property property, int id) {

        Property oldProperty = propertyRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Property doesnt exist"));

        oldProperty.setId(property.getId());
        oldProperty.setAddress(property.getAddress());
        oldProperty.setType(property.getType());
        oldProperty.setPrice(property.getPrice());
        oldProperty.setSize(property.getSize());
        oldProperty.setBedrooms(property.getBedrooms());
        oldProperty.setBathrooms(property.getBathrooms());
        oldProperty.setAmentities(property.getAmentities());
        oldProperty.setDescription(property.getDescription());
        oldProperty.setStatus(property.getStatus());
        oldProperty.setImages(property.getImages());
        return propertyRepository.save(oldProperty);
    }

    @Override
    public Property changeAgent(int propertyId, int agentId) {
        Property oldProperty = propertyRepository.findById(propertyId).orElseThrow(()->new EntityNotFoundException("Property doesnt exist"));
        Agent agent = agentRepository.findById(agentId).orElseThrow(()->new EntityNotFoundException("Agent doesn't exist"));
        oldProperty.setAgent(agent);

        return propertyRepository.save(oldProperty);
    }
}
