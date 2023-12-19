package com.example.security.controllers;

import com.example.security.dtos.PropertyDto;
import com.example.security.entities.Property;
import com.example.security.mappers.PropertyMapper;
import com.example.security.services.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PropertyController {

private final PropertyService propertyService;

    private final PropertyMapper propertyMapper;

    public PropertyController(PropertyService propertyService, PropertyMapper propertyMapper) {
        this.propertyService = propertyService;
        this.propertyMapper = propertyMapper;
    }

    @GetMapping("/properties")
    public List<PropertyDto> findAll(){

        List<Property> properties = propertyService.findAll();
        return properties.stream()
                .map(propertyMapper::toDto)
                .collect(Collectors.toList());
//        return propertyService.findAll();
    }

    @GetMapping("properties/{propertyId}")
    public PropertyDto property (@PathVariable int propertyId){
        Property property = propertyService.findById(propertyId);

        if (property == null){
            throw new RuntimeException("Property id not found - " + propertyId);
        }

        return propertyMapper.toDto(property);
    }

    @PostMapping("/properties")
    public PropertyDto addProperty(@RequestBody PropertyDto property, @RequestParam int agentId){

        Property dbProperty = propertyService.save(propertyMapper.toEntity(property), agentId);

        return propertyMapper.toDto(dbProperty);
    }


    @PutMapping("properties/{propertyId}")
        public PropertyDto updateProperty(@RequestBody PropertyDto propertyDto,@PathVariable int propertyId){

//        Property existingProperty = propertyService.findById(propertyId);
//
//        if (existingProperty == null) {
//            throw new RuntimeException("Property id not found " + propertyId);
//        }
//
//        existingProperty = propertyMapper.toEntity(propertyDto);
//        existingProperty.setId(propertyId);
//
//        Property updatedProperty = propertyService.save(existingProperty,0);

        Property updatedProperty = propertyService.update(propertyMapper.toEntity(propertyDto), propertyId);

        return propertyMapper.toDto(updatedProperty);
    }

    @PatchMapping("properties/{propertyId}/agent/{agentId}")
    public PropertyDto updateAgent(@PathVariable int propertyId, @PathVariable int agentId){

        Property updateAgent = propertyService.changeAgent(propertyId,agentId);

        return propertyMapper.toDto(updateAgent);
    }


    @DeleteMapping("properties/{propertyId}")
    public String deleteEmployee(@PathVariable int propertyId){
        Property tempProperty = propertyService.findById(propertyId);

        if (tempProperty == null){
            throw new RuntimeException("Property id not found " + propertyId);

        }
        propertyService.deleteById(propertyId);

        return "Delete Property id - " + propertyId;

    }

}
