package com.example.examspring2022.api;

import com.example.examspring2022.dto.riderDTO.RiderRequest;
import com.example.examspring2022.dto.riderDTO.RiderResponse;
import com.example.examspring2022.entities.Rider;
import com.example.examspring2022.services.RiderService;
import com.example.examspring2022.services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/riders")
@CrossOrigin("*")
public class RiderController {

    RiderService riderService;
    TeamService teamService;

    public RiderController(RiderService riderService, TeamService teamService) {
        this.riderService = riderService;
        this.teamService = teamService;
    }
    //Create
    @PostMapping()
    public RiderResponse addRider(@RequestBody RiderRequest body) {
        Rider r = new Rider(body);
        //Team add rider
        teamService.findById(body.getTeamId()).addRider(r);
        riderService.addRider(r);
        return new RiderResponse(r);
    }

    //Read
    @GetMapping("/{id}")
    public RiderResponse findRider(@PathVariable int id) {
        return riderService.getRider(id);
    }

    @GetMapping()
    public List<RiderResponse> allRiders(@RequestParam(value="team", required = false) String team) {
        return riderService.getAllRiders(team);
    }

    //Update
    @PutMapping("/edit/{id}")
    public RiderResponse editRider(@PathVariable int id, @RequestBody RiderRequest body) {
        return riderService.editRider(id, body);
    }

    //Delete
    @DeleteMapping("/{id}")
    public void deleteRider(@PathVariable int id) {
        riderService.deleteRider(id);
    }

}
