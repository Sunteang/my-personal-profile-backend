package com.example.personalprofile.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String githubUrl;
    private String demoUrl;
    private List<String> technologies; // project technologies
}
