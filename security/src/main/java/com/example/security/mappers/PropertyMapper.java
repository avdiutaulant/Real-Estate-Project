package com.example.security.mappers;

import com.example.security.dtos.PropertyDto;
import com.example.security.entities.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper {

    public Property toEntity(PropertyDto dto){
        Property property = new Property();
        property.setId(dto.getId());
        property.setAddress(dto.getAddress());
        property.setType(dto.getType());
        property.setPrice(dto.getPrice());
        property.setSize(dto.getSize());
        property.setBedrooms(dto.getBedrooms());
        property.setBathrooms(dto.getBathrooms());
        property.setAmenities(dto.getAmenities());
        property.setDescription(dto.getDescription());
        property.setStatus(dto.getStatus());
        property.setImages(dto.getImages());
        return property;
    }

    public PropertyDto toDto(Property property){
        PropertyDto dto = new PropertyDto();
        dto.setId(property.getId());
        dto.setAddress(property.getAddress());
        dto.setType(property.getType());
        dto.setPrice(property.getPrice());
        dto.setSize(property.getSize());
        dto.setBedrooms(property.getBedrooms());
        dto.setBathrooms(property.getBathrooms());
        dto.setAmenities(property.getAmenities());
        dto.setDescription(property.getDescription());
        dto.setStatus(property.getStatus());
        dto.setAgentName(property.getAgent().getName());
        dto.setImages(property.getImages());
        return dto;
    }
}
