package com.example.personalprofile.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tbl_experience")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private String company;
    private String startDate;
    private String endDate;
    private String type; // INTERNSHIP / JOB / VOLUNTEER

    @Column(length = 1500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
