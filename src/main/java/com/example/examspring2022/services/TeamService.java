package com.example.examspring2022.services;

import com.example.examspring2022.entities.Team;
import com.example.examspring2022.repositories.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team findById(int id) {
        return teamRepository.findById(id);
    }
}
