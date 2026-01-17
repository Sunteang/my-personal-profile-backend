package com.example.personalprofile.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponse {
    private Long id;
    private String fullName;
    private String title;
    private String shortIntro;
    private String biography;
    private String careerObjective;
    private String profileImageUrl;
    private String email;
    private String phone;
    private String location;

    private List<EducationResponse> educations;
    private List<SkillResponse> skills;
    private List<ProjectResponse> projects;
    private List<ExperienceResponse> experiences;
    private List<CertificationResponse> certifications;
    private List<SocialLinkResponse> socialLinks;
}
