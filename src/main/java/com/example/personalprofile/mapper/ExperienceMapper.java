package com.example.personalprofile.mapper;

import com.example.personalprofile.dto.response.ExperienceResponse;
import com.example.personalprofile.models.Experience;

public class ExperienceMapper {

    public static ExperienceResponse toExperienceResponse(Experience e) {
        if (e == null) return null;

        return new ExperienceResponse(
                e.getId(),
                e.getRole(),
                e.getCompany(),
                e.getStartDate(),
                e.getEndDate(),
                e.getType(),
                e.getDescription()
        );
    }
}
