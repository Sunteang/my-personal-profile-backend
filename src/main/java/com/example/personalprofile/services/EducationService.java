package com.example.personalprofile.services;

import com.example.personalprofile.models.Education;
import com.example.personalprofile.repositories.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    public Optional<Education> getEducationById(Long id) {
        return educationRepository.findById(id);
    }

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public Education updateEducation(Long id, Education educationDetails) {
        return educationRepository.findById(id).map(education -> {
            education.setInstitutionName(educationDetails.getInstitutionName());
            education.setDegree(educationDetails.getDegree());
            education.setFieldOfStudy(educationDetails.getFieldOfStudy());
            education.setStartYear(educationDetails.getStartYear());
            education.setEndYear(educationDetails.getEndYear());
            education.setDescription(educationDetails.getDescription());
            return educationRepository.save(education);
        }).orElseThrow(() -> new RuntimeException("Education not found with id " + id));
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
