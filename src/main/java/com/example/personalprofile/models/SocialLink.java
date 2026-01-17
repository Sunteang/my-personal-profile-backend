package com.example.personalprofile.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tbl_social_link")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform; // LinkedIn, GitHub, Twitter
    private String url;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
