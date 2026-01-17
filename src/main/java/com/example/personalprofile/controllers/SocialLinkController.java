package com.example.personalprofile.controllers;

import com.example.personalprofile.dto.response.ApiResponse;
import com.example.personalprofile.dto.response.SocialLinkResponse;
import com.example.personalprofile.mapper.SocialLinkMapper;
import com.example.personalprofile.models.SocialLink;
import com.example.personalprofile.services.SocialLinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/social-links")
public class SocialLinkController {

    private final SocialLinkService socialLinkService;

    public SocialLinkController(SocialLinkService socialLinkService) {
        this.socialLinkService = socialLinkService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SocialLinkResponse>>> getAllSocialLinks() {
        List<SocialLinkResponse> list = socialLinkService.getAllSocialLinks()
                .stream()
                .map(SocialLinkMapper::toSocialLinkResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>("Social links fetched successfully", 200, list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SocialLinkResponse>> getSocialLinkById(@PathVariable Long id) {
        SocialLink s = socialLinkService.getSocialLinkById(id)
                .orElseThrow(() -> new RuntimeException("Social link not found"));
        return ResponseEntity.ok(new ApiResponse<>("Social link fetched successfully", 200, SocialLinkMapper.toSocialLinkResponse(s)));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<SocialLinkResponse>> createSocialLink(@RequestBody SocialLink s) {
        SocialLink created = socialLinkService.createSocialLink(s);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Social link created successfully", 201, SocialLinkMapper.toSocialLinkResponse(created)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse<SocialLinkResponse>> updateSocialLink(@PathVariable Long id, @RequestBody SocialLink s) {
        SocialLink updated = socialLinkService.updateSocialLink(id, s);
        return ResponseEntity.ok(new ApiResponse<>("Social link updated successfully", 200, SocialLinkMapper.toSocialLinkResponse(updated)));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSocialLink(@PathVariable Long id) {
        socialLinkService.deleteSocialLink(id);
        return ResponseEntity.ok(new ApiResponse<>("Social link deleted successfully", 200, null));
    }
}
