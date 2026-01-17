package com.example.personalprofile.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceResponse {
    private String role;
    private String company;
    private String startDate;
    private String endDate;
    private String type;
    private String description;
}
