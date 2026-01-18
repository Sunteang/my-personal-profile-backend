package com.example.personalprofile.mapper;

import com.example.personalprofile.dto.response.SocialLinkResponse;
import com.example.personalprofile.models.SocialLink;

public class SocialLinkMapper {

    public static SocialLinkResponse toSocialLinkResponse(SocialLink s) {
        if (s == null) return null;
        return new SocialLinkResponse(s.getId(), s.getPlatform(), s.getUrl());
    }
}
