package com.example.personalprofile.controllers;

import com.example.personalprofile.dto.response.ApiResponse;
import com.example.personalprofile.dto.response.EducationResponse;
import com.example.personalprofile.models.Education;
import com.example.personalprofile.services.EducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EducationResponse>>> getAllEducations() {
        List<EducationResponse> list = educationService.getAllEducations().stream()
                .map(e -> new EducationResponse(
                        e.getId(),
                        e.getInstitutionName(),
                        e.getDegree(),
                        e.getFieldOfStudy(),
                        e.getStartYear(),
                        e.getEndYear(),
                        e.getDescription()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>("Educations fetched successfully", 200, list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EducationResponse>> getEducationById(@PathVariable Long id) {
        Education e = educationService.getEducationById(id).orElseThrow(() -> new RuntimeException("Education not found"));
        EducationResponse response = new EducationResponse(
                e.getId(),
                e.getInstitutionName(),
                e.getDegree(),
                e.getFieldOfStudy(),
                e.getStartYear(),
                e.getEndYear(),
                e.getDescription()
        );
        return ResponseEntity.ok(new ApiResponse<>("Education fetched successfully", 200, response));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<EducationResponse>> createEducation(@RequestBody Education e) {
        Education created = educationService.createEducation(e);
        EducationResponse response = new EducationResponse(
                created.getId(),
                created.getInstitutionName(),
                created.getDegree(),
                created.getFieldOfStudy(),
                created.getStartYear(),
                created.getEndYear(),
                created.getDescription()
        );
        return ResponseEntity.status(201).body(new ApiResponse<>("Education created", 201, response));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse<EducationResponse>> updateEducation(@PathVariable Long id, @RequestBody Education e) {
        Education updated = educationService.updateEducation(id, e);
        EducationResponse response = new EducationResponse(
                updated.getId(),
                updated.getInstitutionName(),
                updated.getDegree(),
                updated.getFieldOfStudy(),
                updated.getStartYear(),
                updated.getEndYear(),
                updated.getDescription()
        );
        return ResponseEntity.ok(new ApiResponse<>("Education updated", 200, response));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ResponseEntity.ok(new ApiResponse<>("Education deleted", 200, null));
    }
}
