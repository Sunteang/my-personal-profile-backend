package com.example.personalprofile.controllers;

import com.example.personalprofile.dto.response.ApiResponse;
import com.example.personalprofile.dto.response.ProfileResponse;
import com.example.personalprofile.mapper.ProfileMapper;
import com.example.personalprofile.models.Profile;
import com.example.personalprofile.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProfileResponse>>> getAllProfiles() {
        List<ProfileResponse> profiles = profileService.getAllProfiles()
                .stream()
                .map(ProfileMapper::toProfileResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>("Profiles fetched successfully", 200, profiles));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProfileResponse>> getProfileById(@PathVariable Long id) {
        Profile profile = profileService.getProfileById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        return ResponseEntity.ok(new ApiResponse<>("Profile fetched successfully", 200, ProfileMapper.toProfileResponse(profile)));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProfileResponse>> createProfile(@RequestBody Profile profile) {
        Profile createdProfile = profileService.createProfile(profile);
        return new ResponseEntity<>(new ApiResponse<>("Profile created successfully", 201, ProfileMapper.toProfileResponse(createdProfile)), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ProfileResponse>> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        Profile updatedProfile = profileService.updateProfile(id, profile);
        return ResponseEntity.ok(new ApiResponse<>("Profile updated successfully", 200, ProfileMapper.toProfileResponse(updatedProfile)));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.ok(new ApiResponse<>("Profile deleted successfully", 200, null));
    }
}
