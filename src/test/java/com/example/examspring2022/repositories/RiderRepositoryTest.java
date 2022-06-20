package com.example.examspring2022.repositories;

import com.example.examspring2022.entities.Rider;
import com.example.examspring2022.entities.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class RiderRepositoryTest {
    @Autowired
    RiderRepository riderRepository;

    @Autowired
    TeamRepository teamRepository;

    @BeforeEach
    void setup() {
        riderRepository.deleteAll();
        teamRepository.deleteAll();
        Team team1 = new Team("TestTeam");
        Rider rider1 = new Rider("Testnavn1");
        Rider rider2 = new Rider("Testnavn2");

        team1.addRider(rider1);
        team1.addRider(rider2);

        teamRepository.save(team1);
    }

    @Test
    public void getRiders() {
        List<Rider> riders = riderRepository.findAll();
        Assertions.assertEquals(2, riders.size());
    }
}