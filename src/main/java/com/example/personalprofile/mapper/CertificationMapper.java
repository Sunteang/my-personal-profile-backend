package com.example.personalprofile.mapper;

import com.example.personalprofile.dto.response.CertificationResponse;
import com.example.personalprofile.models.Certification;

public class CertificationMapper {

    public static CertificationResponse toCertificationResponse(Certification c) {
        if (c == null) return null;

        return new CertificationResponse(
                c.getName(),
                c.getIssuer(),
                c.getYear(),
                c.getCredentialUrl()
        );
    }
}
