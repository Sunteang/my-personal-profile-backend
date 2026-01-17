package com.example.personalprofile.repositories;

import com.example.personalprofile.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT DISTINCT p FROM Project p LEFT JOIN FETCH p.technologies")
    List<Project> findAllWithTechnologies();

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.technologies WHERE p.id = :id")
    Optional<Project> findByIdWithTechnologies(Long id);
}
