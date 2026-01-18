package com.example.personalprofile.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationResponse {
    private Long id;
    private String institutionName;
    private String degree;
    private String fieldOfStudy;
    private String startYear;
    private String endYear;
    private String description;
}
