package com.example.security.services;

import com.example.security.entities.Agent;
import com.example.security.entities.Property;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AgentService {

    List<Agent> findAll();

    Agent findById(int id);

    Agent save (Agent agent);

    void deleteById(int id);

    Agent update(Agent agent);

}
