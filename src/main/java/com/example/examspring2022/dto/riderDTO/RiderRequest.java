package com.example.examspring2022.dto.riderDTO;

import com.example.examspring2022.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiderRequest {
    private int id;
    private String name;
    private int teamId;
    private int age;
    private int mountainPoints;
    private int sprintPoints;
    private double bestTime;
}
