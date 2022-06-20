package com.example.examspring2022.config;

import com.example.examspring2022.entities.Rider;
import com.example.examspring2022.entities.Team;
import com.example.examspring2022.repositories.RiderRepository;
import com.example.examspring2022.repositories.TeamRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class TestData implements ApplicationRunner {

    RiderRepository riderRepository;
    TeamRepository teamRepository;

    public TestData(TeamRepository teamRepository, RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
        this.teamRepository = teamRepository;
    }

    public void makeData() {
        Team team1 =  new Team("Team 1");
        Team team2 =  new Team("Team 2");

        Rider rider1 = new Rider("Rider 1", 12, 12, 25, 2.5);
        Rider rider2 = new Rider("Rider 2", 15, 5, 32, 3.5);
        Rider rider3 = new Rider("Rider 3", 2, 18, 21, 4.5);
        Rider rider4 = new Rider("Rider 4", 7, 8, 43, 2.7);

        team1.addRider(rider1);
        team1.addRider(rider2);
        team2.addRider(rider3);
        team2.addRider(rider4);

        teamRepository.save(team1);
        teamRepository.save(team2);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeData();
        System.out.println("Ran TestData");
    }
}
