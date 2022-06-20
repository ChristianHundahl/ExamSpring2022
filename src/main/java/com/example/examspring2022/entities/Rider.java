package com.example.examspring2022.entities;

import com.example.examspring2022.dto.riderDTO.RiderRequest;
import com.example.examspring2022.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int mountainPoints;

    private int sprintPoints;

    private int age;

    private double bestTime;

    @ManyToOne
    Team team;

    public Rider(String name) {
        this.name = name;
    }

    public Rider(String name, int mountainPoints, int sprintPoints, int age, double bestTime) {
        this.name = name;
        this.mountainPoints = mountainPoints;
        this.sprintPoints = sprintPoints;
        this.age = age;
        this.bestTime = bestTime;
    }

    public Rider(RiderRequest body) {
        this.name = body.getName();
        this.mountainPoints = body.getMountainPoints();
        this.sprintPoints = body.getSprintPoints();
    }

}
