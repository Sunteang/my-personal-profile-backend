package com.example.personalprofile.services;

import com.example.personalprofile.models.Experience;
import com.example.personalprofile.repositories.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> getExperienceById(Long id) {
        return experienceRepository.findById(id);
    }

    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience updateExperience(Long id, Experience experienceDetails) {
        return experienceRepository.findById(id).map(experience -> {
            experience.setRole(experienceDetails.getRole());
            experience.setCompany(experienceDetails.getCompany());
            experience.setStartDate(experienceDetails.getStartDate());
            experience.setEndDate(experienceDetails.getEndDate());
            experience.setType(experienceDetails.getType());
            experience.setDescription(experienceDetails.getDescription());
            return experienceRepository.save(experience);
        }).orElseThrow(() -> new RuntimeException("Experience not found with id " + id));
    }

    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}
