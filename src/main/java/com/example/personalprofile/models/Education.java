package com.example.personalprofile.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tbl_education")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institutionName;
    private String degree;
    private String fieldOfStudy;
    private String startYear;
    private String endYear;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
