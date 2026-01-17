package com.example.personalprofile.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialLinkResponse {
    private String platform;
    private String url;
}
