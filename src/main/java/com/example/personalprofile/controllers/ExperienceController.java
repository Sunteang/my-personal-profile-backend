package com.example.personalprofile.controllers;

import com.example.personalprofile.dto.response.ApiResponse;
import com.example.personalprofile.dto.response.ExperienceResponse;
import com.example.personalprofile.mapper.ExperienceMapper;
import com.example.personalprofile.models.Experience;
import com.example.personalprofile.services.ExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ExperienceResponse>>> getAllExperiences() {
        List<ExperienceResponse> list = experienceService.getAllExperiences()
                .stream()
                .map(ExperienceMapper::toExperienceResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>("Experiences fetched successfully", 200, list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ExperienceResponse>> getExperienceById(@PathVariable Long id) {
        Experience e = experienceService.getExperienceById(id)
                .orElseThrow(() -> new RuntimeException("Experience not found"));
        return ResponseEntity.ok(new ApiResponse<>("Experience fetched successfully", 200, ExperienceMapper.toExperienceResponse(e)));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ExperienceResponse>> createExperience(@RequestBody Experience e) {
        Experience created = experienceService.createExperience(e);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Experience created successfully", 201, ExperienceMapper.toExperienceResponse(created)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ExperienceResponse>> updateExperience(@PathVariable Long id, @RequestBody Experience e) {
        Experience updated = experienceService.updateExperience(id, e);
        return ResponseEntity.ok(new ApiResponse<>("Experience updated successfully", 200, ExperienceMapper.toExperienceResponse(updated)));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
        return ResponseEntity.ok(new ApiResponse<>("Experience deleted successfully", 200, null));
    }
}
