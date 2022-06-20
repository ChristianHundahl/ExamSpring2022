package com.example.examspring2022.services;

import com.example.examspring2022.dto.riderDTO.RiderRequest;
import com.example.examspring2022.dto.riderDTO.RiderResponse;
import com.example.examspring2022.entities.Rider;
import com.example.examspring2022.entities.Team;
import com.example.examspring2022.repositories.RiderRepository;
import com.example.examspring2022.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RiderService {

    RiderRepository riderRepository;
    TeamRepository teamRepository;

    public RiderService(RiderRepository riderRepository, TeamRepository teamRepository) {
        this.riderRepository = riderRepository;
        this.teamRepository = teamRepository;
    }

    public RiderResponse addRider(Rider rider) {
        riderRepository.save(rider);
        return new RiderResponse(rider);
    }

    public RiderResponse getRider(int id) {
        Rider r = riderRepository.findById(id).orElseThrow();
        return new RiderResponse(r);
    }

    public List<RiderResponse> getAllRiders(String team) {
        List<Rider> riders = new ArrayList<>();
        if (team != null) {
            riders = riderRepository.findRiderByTeam_TeamName(team);
        } else {
            riders = riderRepository.findAll();
        }
        return riders.stream().map(RiderResponse::new).collect(Collectors.toList());
    }

    public RiderResponse editRider(int id, RiderRequest body) {
        Rider newRider = riderRepository.findById(id).orElseThrow();
        newRider.setName(body.getName());
        newRider.setMountainPoints(body.getMountainPoints());
        newRider.setSprintPoints(body.getSprintPoints());
        newRider.setAge(body.getAge());
        newRider.setBestTime(body.getBestTime());
        newRider.setTeam(teamRepository.findById(body.getTeamId()));
        riderRepository.save(newRider);
        return new RiderResponse(newRider);
    }

    public void deleteRider(int id) {
        Rider toBeDeleted = riderRepository.findById(id).orElseThrow();
        Team team = teamRepository.findById(toBeDeleted.getTeam().getId());
        team.getRiders().remove(toBeDeleted);
        riderRepository.delete(toBeDeleted);
    }
}
