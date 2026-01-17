package com.example.personalprofile.controllers;

import com.example.personalprofile.dto.response.ApiResponse;
import com.example.personalprofile.dto.response.CertificationResponse;
import com.example.personalprofile.mapper.CertificationMapper;
import com.example.personalprofile.models.Certification;
import com.example.personalprofile.services.CertificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/certifications")
public class CertificationController {

    private final CertificationService certificationService;

    public CertificationController(CertificationService certificationService) {
        this.certificationService = certificationService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CertificationResponse>>> getAllCertifications() {
        List<CertificationResponse> list = certificationService.getAllCertifications()
                .stream()
                .map(CertificationMapper::toCertificationResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>("Certifications fetched successfully", 200, list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CertificationResponse>> getCertificationById(@PathVariable Long id) {
        Certification c = certificationService.getCertificationById(id)
                .orElseThrow(() -> new RuntimeException("Certification not found"));
        return ResponseEntity.ok(new ApiResponse<>("Certification fetched successfully", 200, CertificationMapper.toCertificationResponse(c)));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CertificationResponse>> createCertification(@RequestBody Certification c) {
        Certification created = certificationService.createCertification(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Certification created successfully", 201, CertificationMapper.toCertificationResponse(created)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse<CertificationResponse>> updateCertification(@PathVariable Long id, @RequestBody Certification c) {
        Certification updated = certificationService.updateCertification(id, c);
        return ResponseEntity.ok(new ApiResponse<>("Certification updated successfully", 200, CertificationMapper.toCertificationResponse(updated)));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCertification(@PathVariable Long id) {
        certificationService.deleteCertification(id);
        return ResponseEntity.ok(new ApiResponse<>("Certification deleted successfully", 200, null));
    }
}
