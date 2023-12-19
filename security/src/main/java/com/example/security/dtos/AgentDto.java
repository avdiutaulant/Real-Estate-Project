package com.example.security.dtos;

import com.example.security.entities.Rating;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDto {

    private int  id;
    private String name;
    private String contactInfo;
    private String email;

    private Rating rating;
}
