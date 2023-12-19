package com.example.security.services;

import com.example.security.entities.Agent;
import com.example.security.mappers.AgentMapper;
import com.example.security.repositories.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final AgentMapper agentMapper;

    public AgentServiceImpl(AgentRepository agentRepository, AgentMapper agentMapper) {
        this.agentRepository = agentRepository;
        this.agentMapper = agentMapper;
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Override
    public Agent findById(int id) {

        Optional<Agent> result = agentRepository.findById(id);

        Agent agent = null;

        if (result.isPresent()){
            agent = result.get();
        } else {
            throw new RuntimeException("Did not find agent id " + id);
        }

        return agent;
    }

    @Override
    public Agent save(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public void deleteById(int id) {

        agentRepository.deleteById(id);
    }

    @Override
    public Agent update(Agent agent) {
        return agentRepository.save(agent);
    }
}
