package com.example.personalprofile.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tbl_project_technology")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String technologyName;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
