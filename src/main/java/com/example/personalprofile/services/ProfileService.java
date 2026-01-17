package com.example.personalprofile.services;

import com.example.personalprofile.models.Profile;
import com.example.personalprofile.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile updatedProfile) {
        return profileRepository.findById(id)
                .map(profile -> {
                    profile.setFullName(updatedProfile.getFullName());
                    profile.setTitle(updatedProfile.getTitle());
                    profile.setShortIntro(updatedProfile.getShortIntro());
                    profile.setBiography(updatedProfile.getBiography());
                    profile.setCareerObjective(updatedProfile.getCareerObjective());
                    profile.setProfileImageUrl(updatedProfile.getProfileImageUrl());
                    profile.setEmail(updatedProfile.getEmail());
                    profile.setPhone(updatedProfile.getPhone());
                    profile.setLocation(updatedProfile.getLocation());
                    return profileRepository.save(profile);
                })
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
