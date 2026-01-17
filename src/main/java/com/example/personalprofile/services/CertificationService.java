package com.example.personalprofile.services;

import com.example.personalprofile.models.Certification;
import com.example.personalprofile.repositories.CertificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

    private final CertificationRepository certificationRepository;

    public CertificationService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Optional<Certification> getCertificationById(Long id) {
        return certificationRepository.findById(id);
    }

    public Certification createCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    public Certification updateCertification(Long id, Certification certificationDetails) {
        return certificationRepository.findById(id).map(cert -> {
            cert.setName(certificationDetails.getName());
            cert.setIssuer(certificationDetails.getIssuer());
            cert.setYear(certificationDetails.getYear());
            cert.setCredentialUrl(certificationDetails.getCredentialUrl());
            return certificationRepository.save(cert);
        }).orElseThrow(() -> new RuntimeException("Certification not found with id " + id));
    }

    public void deleteCertification(Long id) {
        certificationRepository.deleteById(id);
    }
}
