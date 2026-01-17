package com.example.personalprofile.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tbl_certification")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String issuer;
    private String year;
    private String credentialUrl;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
