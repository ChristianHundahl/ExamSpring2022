package com.example.examspring2022.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String teamName;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    List<Rider> riders = new ArrayList<>();

    //Constructor
    public Team(String teamName) {
        this.teamName = teamName;
    }

    //Add rider
    public void addRider(Rider rider) {
        this.riders.add(rider);
        rider.setTeam(this);
    }

    //Add multiple riders
    public void addRiders(List<Rider> riders) {
        this.riders.addAll(riders);
        for (Rider rider : riders) {
            rider.setTeam(this);
        }
    }
}
