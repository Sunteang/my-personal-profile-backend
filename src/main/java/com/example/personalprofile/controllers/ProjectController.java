package com.example.personalprofile.controllers;

import com.example.personalprofile.dto.response.ApiResponse;
import com.example.personalprofile.dto.response.ProjectResponse;
import com.example.personalprofile.mapper.ProjectMapper;
import com.example.personalprofile.models.Project;
import com.example.personalprofile.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectResponse>>> getAllProjects() {
        List<ProjectResponse> list = projectService.getAllProjects()
                .stream()
                .map(ProjectMapper::toProjectResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>("Projects fetched successfully", 200, list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectResponse>> getProjectById(@PathVariable Long id) {
        Project p = projectService.getProjectById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        return ResponseEntity.ok(new ApiResponse<>("Project fetched successfully", 200, ProjectMapper.toProjectResponse(p)));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProjectResponse>> createProject(@RequestBody Project p) {
        Project created = projectService.createProject(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("Project created successfully", 201, ProjectMapper.toProjectResponse(created)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ProjectResponse>> updateProject(@PathVariable Long id, @RequestBody Project p) {
        Project updated = projectService.updateProject(id, p);
        return ResponseEntity.ok(new ApiResponse<>("Project updated successfully", 200, ProjectMapper.toProjectResponse(updated)));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok(new ApiResponse<>("Project deleted successfully", 200, null));
    }
}
