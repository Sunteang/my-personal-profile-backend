package com.example.personalprofile.mapper;

import com.example.personalprofile.dto.response.*;
import com.example.personalprofile.models.Profile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProfileMapper {

    public static ProfileResponse toProfileResponse(Profile profile) {
        if (profile == null) return null;

        return ProfileResponse.builder()
                .id(profile.getId())
                .fullName(profile.getFullName())
                .title(profile.getTitle())
                .shortIntro(profile.getShortIntro())
                .biography(profile.getBiography())
                .careerObjective(profile.getCareerObjective())
                .profileImageUrl(profile.getProfileImageUrl())
                .email(profile.getEmail())
                .phone(profile.getPhone())
                .location(profile.getLocation())

                .educations(mapList(
                        profile.getEducations(),
                        EducationMapper::toEducationResponse
                ))

                .skills(mapList(
                        profile.getSkills(),
                        SkillMapper::toSkillResponse
                ))

                .projects(mapList(
                        profile.getProjects(),
                        ProjectMapper::toProjectResponse
                ))

                .experiences(mapList(
                        profile.getExperiences(),
                        ExperienceMapper::toExperienceResponse
                ))

                .certifications(mapList(
                        profile.getCertifications(),
                        CertificationMapper::toCertificationResponse
                ))

                .socialLinks(mapList(
                        profile.getSocialLinks(),
                        SocialLinkMapper::toSocialLinkResponse
                ))

                .build();
    }

    /**
     * Generic null-safe list mapper
     */
    private static <T, R> List<R> mapList(
            List<T> source,
            java.util.function.Function<T, R> mapper
    ) {
        return Optional.ofNullable(source)
                .orElse(Collections.emptyList())
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
