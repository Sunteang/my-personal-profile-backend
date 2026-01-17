package com.example.personalprofile.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillResponse {
    private String name;
    private String category;
    private int level;
}
