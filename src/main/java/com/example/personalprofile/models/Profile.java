package com.example.personalprofile.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String title;
    private String shortIntro;

    @Column(length = 2000)
    private String biography;

    @Column(length = 1000)
    private String careerObjective;

    private String profileImageUrl;
    private String email;
    private String phone;
    private String location;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Certification> certifications = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<SocialLink> socialLinks = new ArrayList<>();
}

