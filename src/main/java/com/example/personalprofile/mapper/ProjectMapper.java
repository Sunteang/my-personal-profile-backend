package com.example.personalprofile.mapper;

import com.example.personalprofile.dto.response.ProjectResponse;
import com.example.personalprofile.models.Project;

import java.util.List;

public class ProjectMapper {

    public static ProjectResponse toProjectResponse(Project p) {
        if (p == null) return null;

        return ProjectResponse.builder()
                .id(p.getId())
                .title(p.getTitle())
                .description(p.getDescription())
                .imageUrl(p.getImageUrl())
                .githubUrl(p.getGithubUrl())
                .demoUrl(p.getDemoUrl())
                .technologies(
                        p.getTechnologies() == null
                                ? List.of()
                                : p.getTechnologies()
                                .stream()
                                .map(t -> t.getTechnologyName())
                                .toList()
                )
                .build();
    }
}
