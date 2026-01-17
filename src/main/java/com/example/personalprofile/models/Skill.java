package com.example.personalprofile.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tbl_skill")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private int level;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
