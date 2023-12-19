package com.example.security.mappers;

import com.example.security.dtos.AgentDto;
import com.example.security.entities.Agent;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper {

    public Agent toEntity(AgentDto agentDto){
        Agent agent = new Agent();
        agent.setId(agentDto.getId());
        agent.setName(agentDto.getName());
        agent.setContactInfo(agentDto.getContactInfo());
        agent.setEmail(agentDto.getEmail());
        agent.setRating(agentDto.getRating());

        return agent;
    }

    public void updateEntity(AgentDto agentDto, Agent agent) {
        agent.setName(agentDto.getName());
        agent.setContactInfo(agentDto.getContactInfo());
        agent.setEmail(agentDto.getEmail());
        agent.setRating(agentDto.getRating());
        }

    public AgentDto toDto(Agent agent){
        AgentDto agentDto = new AgentDto();
        agentDto.setId(agent.getId());
        agentDto.setName(agent.getName());
        agentDto.setContactInfo(agent.getContactInfo());
        agentDto.setEmail(agent.getEmail());
        agentDto.setRating(agent.getRating());

        return agentDto;
    }
}
