package com.example.personalprofile.mapper;

import com.example.personalprofile.dto.response.SkillResponse;
import com.example.personalprofile.models.Skill;

public class SkillMapper {

    public static SkillResponse toSkillResponse(Skill s) {
        if (s == null) return null;
        return new SkillResponse(s.getName(), s.getCategory(), s.getLevel());
    }
}
