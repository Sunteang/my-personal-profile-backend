package com.example.personalprofile.repositories;

import com.example.personalprofile.models.ProjectTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTechnologyRepository extends JpaRepository<ProjectTechnology, Long> {
}