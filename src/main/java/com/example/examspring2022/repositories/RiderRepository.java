package com.example.examspring2022.repositories;

import com.example.examspring2022.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Integer> {
    List<Rider> findRiderByTeam_TeamName(String teamName);
}
