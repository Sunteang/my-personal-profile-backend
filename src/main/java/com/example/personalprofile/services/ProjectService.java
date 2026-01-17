package com.example.personalprofile.services;

import com.example.personalprofile.models.Project;
import com.example.personalprofile.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAllWithTechnologies();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findByIdWithTechnologies(id);
    }

    public Project createProject(Project project) {

        // 🔴 VERY IMPORTANT: set back-reference
        if (project.getTechnologies() != null) {
            project.getTechnologies()
                    .forEach(t -> t.setProject(project));
        }

        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project projectDetails) {
        return projectRepository.findByIdWithTechnologies(id)
                .map(project -> {
                    project.setTitle(projectDetails.getTitle());
                    project.setDescription(projectDetails.getDescription());
                    project.setImageUrl(projectDetails.getImageUrl());
                    project.setGithubUrl(projectDetails.getGithubUrl());
                    project.setDemoUrl(projectDetails.getDemoUrl());

                    // replace technologies safely
                    project.getTechnologies().clear();
                    if (projectDetails.getTechnologies() != null) {
                        projectDetails.getTechnologies().forEach(t -> {
                            t.setProject(project);
                            project.getTechnologies().add(t);
                        });
                    }

                    return projectRepository.save(project);
                })
                .orElseThrow(() -> new RuntimeException("Project not found with id " + id));
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
