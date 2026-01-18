package com.example.personalprofile.mapper;

import com.example.personalprofile.dto.response.EducationResponse;
import com.example.personalprofile.models.Education;

public class EducationMapper {

    public static EducationResponse toEducationResponse(Education e) {
        if (e == null) return null;

        return new EducationResponse(
                e.getId(),
                e.getInstitutionName(),
                e.getDegree(),
                e.getFieldOfStudy(),
                e.getStartYear(),
                e.getEndYear(),
                e.getDescription()
        );
    }
}
