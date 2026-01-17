package com.example.personalprofile.services;

import com.example.personalprofile.models.SocialLink;
import com.example.personalprofile.repositories.SocialLinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialLinkService {

    private final SocialLinkRepository socialLinkRepository;

    public SocialLinkService(SocialLinkRepository socialLinkRepository) {
        this.socialLinkRepository = socialLinkRepository;
    }

    public List<SocialLink> getAllSocialLinks() {
        return socialLinkRepository.findAll();
    }

    public Optional<SocialLink> getSocialLinkById(Long id) {
        return socialLinkRepository.findById(id);
    }

    public SocialLink createSocialLink(SocialLink socialLink) {
        return socialLinkRepository.save(socialLink);
    }

    public SocialLink updateSocialLink(Long id, SocialLink socialLinkDetails) {
        return socialLinkRepository.findById(id).map(link -> {
            link.setPlatform(socialLinkDetails.getPlatform());
            link.setUrl(socialLinkDetails.getUrl());
            return socialLinkRepository.save(link);
        }).orElseThrow(() -> new RuntimeException("SocialLink not found with id " + id));
    }

    public void deleteSocialLink(Long id) {
        socialLinkRepository.deleteById(id);
    }
}
