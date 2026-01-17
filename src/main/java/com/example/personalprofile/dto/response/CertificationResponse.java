package com.example.personalprofile.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificationResponse {
    private String name;
    private String issuer;
    private String year;
    private String credentialUrl;
}
