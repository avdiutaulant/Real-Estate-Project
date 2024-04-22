package com.example.security.controllers;

import com.example.security.dtos.AgentDto;
import com.example.security.entities.Agent;
import com.example.security.mappers.AgentMapper;
import com.example.security.services.AgentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/agents")
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyRole('ADMIN', 'USER', 'AGENT')")
public class AgentController {

    private final AgentService agentService;

    private final AgentMapper agentMapper;

    public AgentController(AgentService agentService, AgentMapper agentMapper) {
        this.agentService = agentService;
        this.agentMapper = agentMapper;
    }


    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('admin:read','user:read','agent:read')")
    public List<AgentDto> findAll(){
        List<Agent> agents = agentService.findAll();

        return agents
                .stream()
                .map(agentMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{agentId}")
    @PreAuthorize("hasAnyAuthority('admin:read','user:read','agent:read')")
    public AgentDto agent (@PathVariable int agentId){
        Agent agent = agentService.findById(agentId);

        if (agent == null){
            throw new RuntimeException("Agent id not found - " + agentId);
        }

        return agentMapper.toDto(agent);
    }

    @PostMapping("")
    @PreAuthorize("isAuthenticated() and hasAuthority('admin:create')")
    public AgentDto addAgent(@RequestBody AgentDto agent){

        agent.setId(0);

        Agent dbAgent = agentService.save(agentMapper.toEntity(agent));

        return agentMapper.toDto(dbAgent);
    }


    @PutMapping("{agentId}")
    @PreAuthorize("isAuthenticated() and hasAuthority('admin:update')")
    public AgentDto updateAgent(@RequestBody AgentDto agentDto, @PathVariable int agentId){
        Agent existingAgent = agentService.findById(agentId);

        if (existingAgent == null){
            throw new RuntimeException("Agent id not found - " + agentId);
        }

        agentMapper.updateEntity(agentDto, existingAgent);

        Agent updatedAgent = agentService.save(existingAgent);

        return agentMapper.toDto(updatedAgent);

    }


    @DeleteMapping("{agentId}")
    @PreAuthorize("isAuthenticated() and hasAuthority('admin:delete')")
    public String deleteAgent(@PathVariable int agentId){
        Agent tempAgent = agentService.findById(agentId);

        if (tempAgent == null){
            throw new RuntimeException("Agent id not found " + agentId);
        }
        agentService.deleteById(agentId);

        return "Delete Agent id - " + agentId;

    }

}


