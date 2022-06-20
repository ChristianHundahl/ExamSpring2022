package com.example.examspring2022.dto.riderDTO;

import com.example.examspring2022.entities.Rider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RiderResponse {
    private int id;
    private String name;
    private String team;
    private int age;
    private int mountainPoints;
    private int sprintPoints;
    private double bestTime;

    public RiderResponse(Rider rider) {
        this.id = rider.getId();
        this.name = rider.getName();
        this.team = rider.getTeam().getTeamName();
        this.age = rider.getAge();
        this.mountainPoints = rider.getMountainPoints();
        this.sprintPoints = rider.getSprintPoints();
        this.bestTime = rider.getBestTime();
    }
}
