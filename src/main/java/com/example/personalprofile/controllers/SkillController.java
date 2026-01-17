package com.example.personalprofile.controllers;

import com.example.personalprofile.dto.response.ApiResponse;
import com.example.personalprofile.dto.response.SkillResponse;
import com.example.personalprofile.mapper.SkillMapper;
import com.example.personalprofile.models.Skill;
import com.example.personalprofile.services.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SkillResponse>>> getAllSkills() {
        List<SkillResponse> list = skillService.getAllSkills()
                .stream()
                .map(SkillMapper::toSkillResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>("Skills fetched successfully", 200, list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SkillResponse>> getSkillById(@PathVariable Long id) {
        Skill s = skillService.getSkillById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
        return ResponseEntity.ok(new ApiResponse<>("Skill fetched successfully", 200, SkillMapper.toSkillResponse(s)));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<SkillResponse>> createSkill(@RequestBody Skill s) {
        Skill created = skillService.createSkill(s);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("Skill created successfully", 201, SkillMapper.toSkillResponse(created)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse<SkillResponse>> updateSkill(@PathVariable Long id, @RequestBody Skill s) {
        Skill updated = skillService.updateSkill(id, s);
        return ResponseEntity.ok(new ApiResponse<>("Skill updated successfully", 200, SkillMapper.toSkillResponse(updated)));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.ok(new ApiResponse<>("Skill deleted successfully", 200, null));
    }
}
